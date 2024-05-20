package com.example.demo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * JPA entity class for "Employee"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="employee", schema="public" )
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="first_name", nullable=false, length=255)
    private String     firstName ;

    @Column(name="last_name", nullable=false, length=255)
    private String     lastName ;

    @Column(name="email", length=255)
    private String     email ;

    @Column(name="phone_number", length=20)
    private String     phoneNumber ;

    @Temporal(TemporalType.DATE)
    @Column(name="hire_date")
    private Date       hireDate ;

    @Column(name="job_title", length=255)
    private String     jobTitle ;

    @Column(name="department", length=255)
    private String     department ;

    @Column(name="salary")
    private BigDecimal salary ;

    @Column(name="manager_id")
    private Integer    managerId ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="manager_id", referencedColumnName="id", insertable=false, updatable=false)
    @JsonBackReference
    private Employee employee;

 // Employee entity
    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    private List<Employee> managedEmployees;


    /**
     * Constructor
     */
    public Employee() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName ;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName ;
    }
    public String getLastName() {
        return this.lastName;
    }

    public void setEmail( String email ) {
        this.email = email ;
    }
    public String getEmail() {
        return this.email;
    }

    public void setPhoneNumber( String phoneNumber ) {
        this.phoneNumber = phoneNumber ;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setHireDate( Date hireDate ) {
        this.hireDate = hireDate ;
    }
    public Date getHireDate() {
        return this.hireDate;
    }

    public void setJobTitle( String jobTitle ) {
        this.jobTitle = jobTitle ;
    }
    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setDepartment( String department ) {
        this.department = department ;
    }
    public String getDepartment() {
        return this.department;
    }

    public void setSalary( BigDecimal salary ) {
        this.salary = salary ;
    }
    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setManagerId( Integer managerId ) {
        this.managerId = managerId ;
    }
    public Integer getManagerId() {
        return this.managerId;
    }

    //--- GETTERS FOR LINKS
    public Employee getEmployee() {
        return this.employee;
    } 

    public List<Employee> getListOfEmployee() {
        return this.managedEmployees;
    }  

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(firstName);
        sb.append("|");
        sb.append(lastName);
        sb.append("|");
        sb.append(email);
        sb.append("|");
        sb.append(phoneNumber);
        sb.append("|");
        sb.append(hireDate);
        sb.append("|");
        sb.append(jobTitle);
        sb.append("|");
        sb.append(department);
        sb.append("|");
        sb.append(salary);
        sb.append("|");
        sb.append(managerId);
        return sb.toString(); 
    } 

}
