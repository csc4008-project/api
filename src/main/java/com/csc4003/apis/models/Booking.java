package com.csc4003.apis.models;

import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="booking_id")
    private int bookingId;

    @Column(name="employee_id")
    private int employeeId;

    @Column(name="room_id")
    private Integer roomId;

    @Column(name="desk_id")
    private Integer deskId;

    @Column(name="start_time")
    private java.sql.Timestamp startTime;

    @Column(name="duration")
    private int duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", insertable=false, updatable=false)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "desk_id", insertable=false, updatable=false)
    private Desk desk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", insertable=false, updatable=false)
    private Employee employee;

    public Booking(int bookingId, int employeeId, Integer roomId, Integer deskId, java.sql.Timestamp startTime, int duration) {
        this.bookingId = bookingId;
        this.employeeId = employeeId;
        this.roomId = roomId;
        this.deskId = deskId;
        this.startTime = startTime;
        this.duration = duration;
    }

    public Booking() {

    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Integer getDeskId() {
        return deskId;
    }

    public void setDeskId(int deskId) {
        this.deskId = deskId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Booking: {" + "bookingId=" + bookingId +  ", employeeId=" + employeeId + ", roomId=" + roomId
                +  ", deskId=" + deskId +  ", startTime=" + startTime + ", duration=" + duration +'}';
    }

}
