package com.example.springejercicio4.controller;

import com.example.springejercicio4.model.User;
import com.example.springejercicio4.service.UserService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping ("/api")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * RETRIEVE - Find all users
     * @return List of users from database
     */
    @GetMapping("/user")
    @ApiOperation("Recuperar todos los usuarios")
    public List<User> findAllUsers() {
        log.debug("REST REQUEST to find all users");
        return userService.findAllUsers();
    }

    /**
     * RETRIEVE - Find user by id
     * @param id Long Primary key - The number by which it will be filtered
     * @return ResponseEntity - Returns a negative answer NOT_FOUND
     */
    @GetMapping("/user/{id}")  //
    @ApiOperation("Encuentra un usuario por su id")
    public ResponseEntity<User> findOne (@PathVariable Long id) {
        log.info("REST REQUEST to find one user by id: {}", id);
        Optional<User> userOpt = userService.findById(id);
        return userOpt.map(employee -> ResponseEntity.ok().body(employee))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * RETRIEVE - Filter user by country
     * @param country String - The name by which it will be filtered
     * @return ResponseEntity - Returns a negative or positive answer
     */
    @GetMapping("/user/country/{country}")
    @ApiOperation("Filtra los usuarios por paises")
    public ResponseEntity<List<User>> findByCountry(@PathVariable String country) {
        log.debug("Filter all employees by country: {}", country);

        List<User> users = userService.filterByCountry(country);

        if (country.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok().body(users);
    }

    /**
     * CREATE - Create user in Postman
     * @param user  the user that will be create
     * @return ResponseEntity -  Returns a negative or positive answer
     * @throws URISyntaxException
     */
    @PostMapping("/users")
    @ApiOperation("Crear un usuario")
    public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {
        log.debug("REST REQUEST to save an user: {} ", user);
        if (user.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        User userDB = userService.createUser(user);
        return ResponseEntity
                .created(new URI("/api/users/" + userDB.getId()))
                .body(userDB);
    }

    /**
     * UPDATE - Update an user in Postman
     * @param user The user that will be update
     * @return ResponseEntity -  Returns a negative or positive answer
     */
    @PutMapping("/user")
    @ApiOperation("Actualizar un usuario")
    public ResponseEntity<User> updateUser (@RequestBody User user){
        log.debug("REST REQUEST to update an user: {}", user);

        if (user.getId() == null){
            log.warn("User without id!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(userService.updateUser(user));
    }

    /**
     * DELETE - Delete an user by id
     * @param id Long Primary key - The number by which it will be filtered
     * @return ResponseEntity : Return an answer noContent()
     */
    @DeleteMapping("/users/{id}")
    @ApiOperation("Borrar un usuario por id")
    public ResponseEntity<Void> deleteUserId (@PathVariable Long id) {
        log.debug("REST REQUEST to delete an user by id {}", id);
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
