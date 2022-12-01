package com.csc4003.apis.Repositories;

import com.csc4003.apis.models.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AttendeeRepository extends CrudRepository<Attendee, Integer> {

    @Query("SELECT a FROM Attendee a WHERE a.booking.bookingId = :bookingId")
    List<Attendee> findAttendeesByBooking(int bookingId);

    List<Attendee> findAttendedBookingsByEmployee(Employee employee);


}
