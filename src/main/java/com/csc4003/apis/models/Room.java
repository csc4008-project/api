package com.csc4003.apis.models;

import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_id")
    private int roomId;

    @Column(name="floor_id")
    private int floorId;

    @Column(name="room_name")
    private String roomName;

    @Column(name="room_type")
    private String roomType;

    @Column(name="capacity")
    private int capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id", insertable=false, updatable=false)
    private Floor floor;

    public Room(int roomId, int floorId, String roomName, String roomType, int capacity) {
        this.roomId = roomId;
        this.floorId = floorId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.capacity = capacity;
    }

    public Room() {

    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", floorId=" + floorId +
                ", roomName='" + roomName + '\'' +
                ", roomType='" + roomType + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
