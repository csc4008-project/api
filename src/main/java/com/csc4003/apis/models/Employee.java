package com.csc4003.apis.models;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private int employeeId;
    @Column(name="full_name")
    private String fullName;
    @Column(name="occupation")
    private String occupation;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    public Employee(String fullName, String occupation, String email, String password) {
        this.fullName = fullName;
        this.occupation = occupation;
        this.email = email;
        this.password = password;
    }

    public Employee() {

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "Employee: {" + "employeeId=" + employeeId +  ", fullName=" + fullName
                 +  ", occupation=" + occupation +  ", email=" + email + '}';
    }
}
