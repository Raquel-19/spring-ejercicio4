package com.example.springejercicio4.service.impl;

import com.example.springejercicio4.model.Business;
import com.example.springejercicio4.repository.BusinessRepository;
import com.example.springejercicio4.service.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessServiceImpl implements BusinessService {

    private final Logger log = LoggerFactory.getLogger(BusinessServiceImpl.class);

    private final BusinessRepository repositoryBusiness;

    public BusinessServiceImpl(BusinessRepository repository2) {
        this.repositoryBusiness = repository2;
    }

    @Override
    public List<Business> findAllBusiness() {
        log.info("findAllBusiness");
        return repositoryBusiness.findAll();
    }

    @Override
    public Optional<Business> findById(Long id) {
        log.info("findOneBusiness");
        if (id == null)
            return Optional.empty();

        return repositoryBusiness.findById(id);
    }

    @Override
    public List<Business> filterByContact (String contact) {
        log.info("findByContact");
        return repositoryBusiness.findByContact(contact);
    }

    @Override
    public Business createBusiness(Business business) {
        log.info("createBusiness");
        if (ObjectUtils.isEmpty(business))
            return null;
        return repositoryBusiness.save(business);
    }

    @Override
    public Business updateBusiness(Business business) {
        log.info("updateBusiness");
        if (ObjectUtils.isEmpty(business))
            return null;
        return repositoryBusiness.save(business);
    }

    @Override
    public void deleteAll() {
        log.info("deleteAllBusiness");
        repositoryBusiness.deleteAll();
    }

    @Override
    public Optional<Business> calculateBilling(Long numberBussiness) {
        log.info("REST REQUEST to find one business by numberBusiness: {}", numberBussiness);
        Optional<Business> businessOptional = this.findById(numberBussiness);

        if(businessOptional.isEmpty() || businessOptional.get().getNumberEmployees() == null
                || businessOptional.get().getNumberProducts() == null || businessOptional.get().getYearsInMarket() == null)
            return businessOptional;

        Business business = businessOptional.get();
        bussinesBilling(business);

        repositoryBusiness.save(business);

        return Optional.of(business);
    }

    public void bussinesBilling(Business business) {

        Double totalBilling = 0.0;
        totalBilling = business.getNumberProducts() * 1500.50;
        totalBilling = totalBilling - (100 *  business.getNumberEmployees());
        totalBilling *= business.getYearsInMarket();

        business.setBilling(totalBilling);
    }
}
