package com.csc4003.apis.models;

public class Booking {

    private String bookingId;

    public Booking(String bookingId) {
        this.bookingId = bookingId;
    }
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
}
