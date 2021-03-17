package com.example.springejercicio4.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table (name = "business")
public class Business {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long numberBusiness;

    @Column (name = "name")
    private String name;

    @Column (name = "number_employees")
    private Integer numberEmployees;

    @Column (name = "number_products")
    private Integer numberProducts;

    @Column (name = "years_in_market")
    private Integer yearsInMarket;

    public Business () {
    }

    public Business(Long numberBusiness, String name) {
        this.numberBusiness = numberBusiness;
        this.name = name;
    }

    public Business(Integer numberEmployees, Integer numberProducts, Integer yearsInMarket) {
        this.numberEmployees = numberEmployees;
        this.numberProducts = numberProducts;
        this.yearsInMarket = yearsInMarket;
    }

    public Long getNumberBusiness() {
        return numberBusiness;
    }

    public void setNumberBusiness(Long numberBusiness) {
        this.numberBusiness = numberBusiness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(Integer numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    public Integer getNumberProducts() {
        return numberProducts;
    }

    public void setNumberProducts(Integer numberProducts) {
        this.numberProducts = numberProducts;
    }

    public Integer getYearsInMarket() {
        return yearsInMarket;
    }

    public void setYearsInMarket(Integer yearsInMarket) {
        this.yearsInMarket = yearsInMarket;
    }

    @Override
    public String toString() {
        return "Business{" +
                "numberBusiness=" + numberBusiness +
                ", name='" + name + '\'' +
                ", numberEmployees=" + numberEmployees +
                ", numberProducts=" + numberProducts +
                ", yearsInMarket=" + yearsInMarket +
                '}';
    }
}
