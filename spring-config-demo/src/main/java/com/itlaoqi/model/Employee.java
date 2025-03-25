package com.itlaoqi.model;

import com.fasterxml.jackson.annotation.*;

import java.time.LocalDate;
import java.util.List;

// 假设我们有这样一个 Employee 类
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"id", "firstName", "lastName", "dob", "address", "departments"})
public class Employee {
    public Employee(){

    }
    public Employee(long id, String firstName, String lastName, LocalDate dob, Address address, String socialSecurityNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.socialSecurityNumber = socialSecurityNumber;

    }

    @JsonProperty("emp_id")
    private long id;

    @JsonProperty(value = "first_name", required = true)
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private Address address;

    // Ignore the sensitive property
    @JsonIgnore
    private String socialSecurityNumber;

    // Include only if not empty or null
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> departments;

    // 构造函数、getter 和 setter 方法省略...

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }

}
