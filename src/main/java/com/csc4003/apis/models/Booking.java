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

    public Booking(Employee employee, Room room, Desk desk, java.sql.Timestamp startTime, int duration) {
        this.employee = employee;
        this.room = room;
        this.desk = desk;
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

    public Room getRoom() {
        return room;
    }

    public Desk getDesk() {
        return desk;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Booking: {" + "bookingId=" + bookingId +  ", employeeId=" + employee.getEmployeeId() + ", roomId=" + room.getRoomId()
                +  ", deskId=" + desk.getDeskId() +  ", startTime=" + startTime + ", duration=" + duration +'}';
    }

    // ---- Room Details Methods
    public String getRoomNumber() {
        return room.getRoomNumber();
    }

    public String getRoomType() {
        return room.getRoomType();
    }

    public int getRoomCapacity() {
        return room.getCapacity();
    }

    // ---- Desk Details Methods
    public String getDeskName() {
        return desk.getDeskName();
    }

    // ---- Space Details Methods
    public String getSpaceName() {
        return desk.getSpace().getSpaceName();
    }

    public String getSpaceType() {
        return desk.getSpace().getSpaceType();
    }

    public int getSpaceDeskCapacity() {
        return desk.getSpace().getDeskCapacity();
    }

    // ---- Floor Details Methods
    public int getFloorNumber() {
        if (room == null) {
            return desk.getSpace().getFloor().getFloorNumber();
        } else if (desk == null) {
            return room.getFloor().getFloorNumber();
        }
        return 0;
    }

    // ---- Building Details Methods
    public String getBuildingDetails() {
        if (room == null) {
            return desk.getSpace().getFloor().getBuilding().getBuildingName() + ", " +
                    desk.getSpace().getFloor().getBuilding().getBuildingShortCode() + ", " +
                    desk.getSpace().getFloor().getBuilding().getAddressLine1() + ", " +
                    desk.getSpace().getFloor().getBuilding().getAddressLine2() + ", " +
                    desk.getSpace().getFloor().getBuilding().getPostcode() + ", " +
                    desk.getSpace().getFloor().getBuilding().getCity() + ", " +
                    desk.getSpace().getFloor().getBuilding().getCounty() + ", " +
                    desk.getSpace().getFloor().getBuilding().getCountry();
        } else if (desk == null) {
            return room.getFloor().getBuilding().getBuildingName() + ", " +
                    room.getFloor().getBuilding().getBuildingShortCode() + ", " +
                    room.getFloor().getBuilding().getAddressLine1() + ", " +
                    room.getFloor().getBuilding().getAddressLine2() + ", " +
                    room.getFloor().getBuilding().getPostcode() + ", " +
                    room.getFloor().getBuilding().getCity() + ", " +
                    room.getFloor().getBuilding().getCounty() + ", " +
                    room.getFloor().getBuilding().getCountry();
        }
        return "error";
    }

    // ---- Employee Details Methods
    public int getEmployeeId() {
        return employee.getEmployeeId();
    }

    public String getEmployeeFirstName() {
        return employee.getFirstName();
    }

    public String getEmployeeLastName() {
        return employee.getLastName();
    }

    public String getEmployeeOccupation() {
        return employee.getOccupation();
    }

    public String getEmployeeEmail() {
        return employee.getEmail();
    }

}
