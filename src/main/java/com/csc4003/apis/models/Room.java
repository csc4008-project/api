package com.csc4003.apis.models;

import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_id")
    private int roomId;

    @Column(name="room_number")
    private String roomNumber;

    @Column(name="room_type")
    private String roomType;

    @Column(name="capacity")
    private int capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id", insertable=false, updatable=false)
    private Floor floor;

    public Room(Floor floor, String roomNumber, String roomType, int capacity) {
        this.floor = floor;
        this.roomNumber = roomNumber;
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

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomName) {
        this.roomNumber = roomNumber;
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

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", floorId=" + floor.getFloorId() +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
