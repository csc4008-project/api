package com.csc4003.apis.Services;

import com.csc4003.apis.Repositories.AttendeeRepository;
import com.csc4003.apis.models.Attendee;
import com.csc4003.apis.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendeeService {
    
    @Autowired
    private AttendeeRepository attendeeRepository;

    public List<Attendee> getAllAttendees()
    {
        List<Attendee>attendeeRecords = new ArrayList<>();
        attendeeRepository.findAll().forEach(attendeeRecords::add);
        return attendeeRecords;
    }
    public void addAttendee(Attendee attendee)
    {
        attendeeRepository.save(attendee);
    }

    public void updateAttendee(Attendee attendee)
    {
        attendeeRepository.save(attendee);
    }

    public void deleteAttendeeById(int attendeeId) {
        attendeeRepository.deleteById(attendeeId);
    }

    public void findAttendeeById(int attendeeId) {
        attendeeRepository.findById(attendeeId);
    }

    public List<Attendee> findAttendeesByBooking(int bookingId) {
        return attendeeRepository.findAttendeesByBooking(bookingId);
    }

    // list of bookings for all meetings someone is attending
    public List<Attendee> findAttendedBookingsByEmployee(Employee employee) {
        return attendeeRepository.findAttendedBookingsByEmployee(employee);
    }
    
}
