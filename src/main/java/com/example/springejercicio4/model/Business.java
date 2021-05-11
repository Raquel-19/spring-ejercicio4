package com.example.springejercicio4.model;

import javax.persistence.*;

@Entity
@Table (name = "business")

public class Business {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "number_business")
    private Long numberBusiness;

    @Column (name = "name")
    private String name;

    @Column (name = "contact")
    private String contact;

    @Column (name = "number_employees")
    private Integer numberEmployees;

    @Column (name = "number_products")
    private Integer numberProducts;

    @Column (name = "billing")
    private Double billing;

    @Column (name = "years_in_market")
    private Integer yearsInMarket;

    public Business () {
    }

    public Business(Long numberBusiness, String name, String contact, Integer numberEmployees, Integer numberProducts, Double billing, Integer yearsInMarket) {
        this.numberBusiness = numberBusiness;
        this.name = name;
        this.contact = contact;
        this.numberEmployees = numberEmployees;
        this.numberProducts = numberProducts;
        this.billing = billing;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public Double getBilling() {
        return billing;
    }

    public void setBilling(Double billing) {
        this.billing = billing;
    }

    @Override
    public String toString() {
        return "Business{" +
                "numberBusiness=" + numberBusiness +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", numberEmployees=" + numberEmployees +
                ", numberProducts=" + numberProducts +
                ", billing=" + billing +
                ", yearsInMarket=" + yearsInMarket +
                '}';
    }
}
