package com.csc4003.apis.models;

import javax.persistence.*;

@Entity
@Table(name="space")
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="space_id")
    private int spaceId;

    @Column(name="space_name")
    private String spaceName;

    @Column(name="space_type")
    private String spaceType;

    @Column(name="desk_capacity")
    private int deskCapacity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "floor_id", insertable=true, updatable=true)
    private Floor floor;

    public Space(Floor floor, String spaceName, String spaceType, int deskCapacity) {
        this.floor = floor;
        this.spaceName = spaceName;
        this.spaceType = spaceType;
        this.deskCapacity = deskCapacity;
    }

    public Space() {

    }

    public int getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType;
    }

    public int getDeskCapacity() {
        return deskCapacity;
    }

    public void setDeskCapacity(int deskCapacity) {
        this.deskCapacity = deskCapacity;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Space{" +
                "spaceId=" + spaceId +
                ", floorId=" + floor.getFloorId() +
                ", spaceName='" + spaceName + '\'' +
                ", spaceType='" + spaceType + '\'' +
                ", deskCapacity=" + deskCapacity +
                '}';
    }
}
