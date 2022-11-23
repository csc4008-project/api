package com.csc4003.apis.models;

import javax.persistence.*;

@Entity
@Table(name="attendee")
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="attendee_id")
    private int attendeeId;

    @Column(name="booking_id")
    private int bookingId;

    @Column(name="employee_id")
    private int employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", insertable=false, updatable=false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", insertable=false, updatable=false)
    private Employee employee;

    public Attendee(int attendeeId, int bookingId, int employeeId) {
        this.attendeeId = attendeeId;
        this.bookingId = bookingId;
        this.employeeId = employeeId;
    }

    public Attendee() {

    }

    public int getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(int attendeeId) {
        this.attendeeId = attendeeId;
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

    @Override
    public String toString() {
        return "Attendee{" +
                "attendeeId=" + attendeeId +
                ", bookingId=" + bookingId +
                ", employeeId=" + employeeId +
                '}';
    }
}
