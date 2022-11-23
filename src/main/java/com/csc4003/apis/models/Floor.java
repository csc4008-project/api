package com.csc4003.apis.models;

import javax.persistence.*;

@Entity
@Table(name="floor")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="floor_id")
    private int floorId;

    @Column(name="building_id")
    private int buildingId;

    @Column(name="floor_number")
    private int floorNumber;

    @Column(name="floor_name")
    private String floorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id", insertable=false, updatable=false)
    private Building building;

    public Floor(int floorId, int buildingId, int floorNumber, String floorName) {
        this.floorId = floorId;
        this.buildingId = buildingId;
        this.floorNumber = floorNumber;
        this.floorName = floorName;
    }

    public Floor() {

    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorId=" + floorId +
                ", buildingId=" + buildingId +
                ", floorNumber=" + floorNumber +
                ", floorName='" + floorName + '\'' +
                '}';
    }
}
