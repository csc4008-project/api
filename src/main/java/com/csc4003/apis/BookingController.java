package com.csc4003.apis;

import com.csc4003.apis.models.Booking;
import com.csc4003.apis.models.Room;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@RestController
public class BookingController {

    @CrossOrigin
    @GetMapping("/booking")
    public String getBooking(@RequestParam(value = "userId") String test)
    {
        return test;
        //return new Booking(bookingId, employeeId, room, deskId, startTime, duration);
    }
}
