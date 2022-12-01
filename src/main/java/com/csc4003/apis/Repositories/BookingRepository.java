package com.csc4003.apis.Repositories;

import com.csc4003.apis.models.Booking;
import com.csc4003.apis.models.Desk;
import com.csc4003.apis.models.Employee;
import com.csc4003.apis.models.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Integer>
{
    Booking findByEmployee(Employee employee);
    List<Booking> findByRoom(Room room);
    List<Booking> findByDesk(Desk desk);

    @Query("SELECT b FROM Booking b WHERE b.bookingId = :bookingId")
    Booking findBookingDetailsById(int bookingId);

    @Query(value = "SELECT * FROM booking WHERE (:bookingTime BETWEEN start_time AND DATE_ADD(start_time, INTERVAL duration MINUTE)) " +
            "OR (DATE_ADD(:bookingTime, INTERVAL :duration MINUTE) BETWEEN start_time AND DATE_ADD(start_time, INTERVAL duration MINUTE))", nativeQuery = true)
    Booking findBookingTime(Timestamp bookingTime, int duration);

    List<Booking> findAllBookingsByEmployee(Employee employee);


}

