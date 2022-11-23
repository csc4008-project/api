package com.csc4003.apis.models;

import javax.persistence.*;

@Entity
@Table(name="building")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="building_id")
    private int buildingId;

    @Column(name="building_name")
    private String buildingName;

    @Column(name="address_line1")
    private String addressLine1;

    @Column(name="address_line2")
    private String addressLine2;

    @Column(name="postcode")
    private String postcode;

    @Column(name="city")
    private String city;

    @Column(name="county")
    private String county;

    @Column(name="country")
    private String country;

    public Building(int buildingId, String buildingName, String addressLine1, String addressLine2, String postcode, String city, String county, String country) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postcode = postcode;
        this.city = city;
        this.county = county;
        this.country = country;
    }

    public Building() {

    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingId=" + buildingId +
                ", buildingName='" + buildingName + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
