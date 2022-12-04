package com.csc4003.apis.models;

import javax.persistence.*;

@Entity
@Table(name="desk")
public class Desk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="desk_id")
    private int deskId;

    @Column(name="desk_name")
    private String deskName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "space_id", insertable=true, updatable=true)
    private Space space;

    public Desk(Space space, String deskName) {
        this.space = space;
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

    public String getDeskName() {
        return deskName;
    }

    public void setDeskName(String deskName) {
        this.deskName = deskName;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "deskId=" + deskId +
                ", spaceId=" + space.getSpaceId() +
                ", deskName='" + deskName + '\'' +
                '}';
    }
}
