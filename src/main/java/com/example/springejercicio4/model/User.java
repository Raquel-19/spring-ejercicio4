package com.example.springejercicio4.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name ="name")
    private String name;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "age")
    private Integer age;

    @Column (name = "married")
    private Boolean married;

    @Column (name = "country")
    private String country;

    @Column (name = "salary")
    private Double salary;

    public User () {
    }

    public User(String name, String lastName, Integer age, Boolean married, String country, Double salary) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.married = married;
        this.country = country;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", married=" + married +
                ", country='" + country + '\'' +
                ", salary=" + salary +
                '}';
    }
}
