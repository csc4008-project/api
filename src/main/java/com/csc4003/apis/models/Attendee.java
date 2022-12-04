package com.csc4003.apis.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="attendee")
public class Attendee {
    @Id
    @Column(name="attendee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendeeId;

    @ManyToOne(cascade=CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", insertable=true, updatable=true)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", insertable=true, updatable=true)
    private Employee employee;

    public Attendee(Booking booking, Employee employee) {
        this.booking = booking;
        this.employee = employee;
    }

    public Attendee() {

    }

    public int getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(int attendeeId) {
        this.attendeeId = attendeeId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Attendee{" +
                "attendeeId=" + attendeeId +
                ", bookingId=" + booking.getBookingId() +
                ", employeeId=" + employee.getEmployeeId() +
                '}';
    }

    // ---- Employee Details Methods
    public int getEmployeeId() {
        return employee.getEmployeeId();
    }

    public String getEmployeeFullName() {
        return employee.getFullName();
    }

    public String getEmployeeOccupation() {
        return employee.getOccupation();
    }

    public String getEmployeeEmail() {
        return employee.getEmail();
    }
}
