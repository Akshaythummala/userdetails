package com.example.user_details_service.Model;


import jakarta.persistence.*;

@Entity
public class EmploymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address companyAddress;

    private String companyPhone;
    private String principalDuties;
    private String datesOfEmployment;
    private String salary;
    private String reasonForLeaving;

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Address getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(Address companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getPrincipalDuties() {
        return principalDuties;
    }

    public void setPrincipalDuties(String principalDuties) {
        this.principalDuties = principalDuties;
    }

    public String getDatesOfEmployment() {
        return datesOfEmployment;
    }

    public void setDatesOfEmployment(String datesOfEmployment) {
        this.datesOfEmployment = datesOfEmployment;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getReasonForLeaving() {
        return reasonForLeaving;
    }

    public void setReasonForLeaving(String reasonForLeaving) {
        this.reasonForLeaving = reasonForLeaving;
    }
}
