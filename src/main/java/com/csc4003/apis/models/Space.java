package com.csc4003.apis.models;

import javax.persistence.*;

@Entity
@Table(name="space")
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="space_id")
    private int spaceId;

    @Column(name="floor_id")
    private int floorId;

    @Column(name="space_name")
    private String spaceName;

    @Column(name="space_type")
    private String spaceType;

    @Column(name="desk_capacity")
    private int deskCapacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id", insertable=false, updatable=false)
    private Floor floor;

    public Space(int spaceId, int floorId, String spaceName, String spaceType, int deskCapacity) {
        this.spaceId = spaceId;
        this.floorId = floorId;
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

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
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

    @Override
    public String toString() {
        return "Space{" +
                "spaceId=" + spaceId +
                ", floorId=" + floorId +
                ", spaceName='" + spaceName + '\'' +
                ", spaceType='" + spaceType + '\'' +
                ", deskCapacity=" + deskCapacity +
                '}';
    }
}
