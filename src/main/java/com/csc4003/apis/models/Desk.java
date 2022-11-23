package com.csc4003.apis.models;

import javax.persistence.*;

@Entity
@Table(name="desk")
public class Desk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="desk_id")
    private int deskId;

    @Column(name="space_id")
    private int spaceId;

    @Column(name="desk_name")
    private String deskName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id")
    private Floor floor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "space_id")
    private Space space;

    public Desk(int deskId, int spaceId, String deskName) {
        this.deskId = deskId;
        this.spaceId = spaceId;
        this.deskName = deskName;
    }

    public Desk() {

    }

    public int getDeskId() {
        return deskId;
    }

    public void setDeskId(int deskId) {
        this.deskId = deskId;
    }

    public int getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }

    public String getDeskName() {
        return deskName;
    }

    public void setDeskName(String deskName) {
        this.deskName = deskName;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "deskId=" + deskId +
                ", spaceId=" + spaceId +
                ", deskName='" + deskName + '\'' +
                '}';
    }
}
