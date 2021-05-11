package com.example.springejercicio4.controller;

import com.example.springejercicio4.model.Business;
import com.example.springejercicio4.model.User;
import com.example.springejercicio4.service.BusinessService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BusinessController {

    private final Logger log = LoggerFactory.getLogger(BusinessController.class);
    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    /**
     * RETRIEVE - Find all business
     * @return List of businesses from database
     */
    @GetMapping("/business")
    @ApiOperation("Recuperar todas las empresas")
    public List<Business> findAllBusiness() {
        log.debug("REST REQUEST to find all business");
        return businessService.findAllBusiness();
    }

    /**
     * RETRIEVE - Find business by id
     * @param numberBusiness Long Primary key - The number by which it will be filtered
     * @return ResponseEntity : Returns a negative or positive answer
     */
    @GetMapping("/business/{numberBusiness}")  //
    @ApiOperation("Encuentra una empresa por su clave primaria")
    public ResponseEntity<Business> findOne (@PathVariable Long numberBusiness) {
        log.info("REST REQUEST to find one business by numberBusiness: {}", numberBusiness);
        Optional<Business> userOpt = businessService.findById(numberBusiness);
        return userOpt.map(business -> ResponseEntity.ok().body(business))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * RETRIEVE - Filter business by contact
     * @param contact String - The name by which it will be filtered
     * @return ResponseEntity : Returns a negative or positive answer
     */
    @GetMapping("/business/contact/{contact}")
    @ApiOperation("Filtra las empresas por contactos")
    public ResponseEntity<List<Business>> findByContact (@PathVariable String contact) {
        log.debug("Filter business by contact: {}", contact);

        List<Business> businesses = businessService.filterByContact(contact);

        if (contact.isEmpty ())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok().body(businesses);
    }

    /**
     * CREATE - Create business in Postman
     * @param business the business that will be create
     * @return  ResponseEntity : Returns a negative or positive answer
     * @throws URISyntaxException
     */
    @PostMapping("/business")
    public ResponseEntity<Business> createBusiness (@RequestBody Business business) throws URISyntaxException {
        log.debug("REST request to save an business: {} ", business);
        if (business.getNumberBusiness() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Business businessBD = businessService.createBusiness(business);
        return ResponseEntity
                .created(new URI("/api/business/" + businessBD.getNumberBusiness()))
                .body(businessBD);
    }

    /**
     * UPDATE - Update an business in Postman
     * @param business The business that will be update
     * @return ResponseEntity :Returns a negative or positive answer
     */
    @PutMapping("/business")
    @ApiOperation("Actualizar una empresa")
    public ResponseEntity<Business> updateBusiness (@RequestBody Business business){
        log.debug("REST REQUEST to update an business: {}", business);

        if (business.getNumberBusiness() == null){
            log.warn("Business without id!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(businessService.updateBusiness(business));
    }

    /**
     * DELETE - Delete all business
     * @return ResponseEntity : Return an answer noContent()
     */
    @DeleteMapping("/business")
    @ApiOperation("Borrar todas las empresas")
    public ResponseEntity<Void> deleteAllBusiness() {
        log.debug("REST REQUEST to delete all business");
        businessService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    /**
     * PROCESS - Calculate company turnover
     * @param numberBusiness Long Primary key - El numero por el que será filtrado
     * @return ResponseEntity : Returns a negative answer NOT_FOUND
     */
    @GetMapping("/business/calculateBilling/{numberBusiness}")
    public ResponseEntity<Business> calculateSalary(@PathVariable Long numberBusiness){
        return businessService.calculateBilling(numberBusiness).map(
                business -> ResponseEntity.ok().body(business))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
