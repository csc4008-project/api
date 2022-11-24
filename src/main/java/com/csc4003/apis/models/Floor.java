package com.csc4003.apis.models;

import javax.persistence.*;

@Entity
@Table(name="floor")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="floor_id")
    private int floorId;

    @Column(name="floor_number")
    private int floorNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id", insertable=false, updatable=false)
    private Building building;

    public Floor(Building building, int floorNumber) {
        this.building = building;
        this.floorNumber = floorNumber;
    }

    public Floor() {

    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorId=" + floorId +
                ", buildingId=" + building.getBuildingId() +
                ", floorNumber=" + floorNumber +
                '}';
    }
}
