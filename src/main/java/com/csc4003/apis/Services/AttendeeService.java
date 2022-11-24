package com.csc4003.apis.Services;

import com.csc4003.apis.Repositories.AttendeeRepository;
import com.csc4003.apis.models.Attendee;
import com.csc4003.apis.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendeeService {
    
    @Autowired
    private AttendeeRepository attendeeRepository;

    public List<Booking> getAllBookings()
    {
        List<Booking>attendeeRecords = new ArrayList<>();
        attendeeRepository.findAll().forEach(attendeeRecords::add);
        return attendeeRecords;
    }
    public void addBooking(Booking attendee)
    {
        attendeeRepository.save(attendee);
    }

    public void updateBooking(Booking attendee)
    {
        attendeeRepository.save(attendee);
    }

    public void deleteBookingById(int attendeeId) {
        attendeeRepository.deleteById(attendeeId);
    }

    public void findBookingById(int attendeeId) {
        attendeeRepository.findById(attendeeId);
    }

    public List<Attendee> findAttendeesByBooking(int bookingId) {
        return attendeeRepository.findAttendeesByBooking(bookingId);
    }
    
    
    
}
