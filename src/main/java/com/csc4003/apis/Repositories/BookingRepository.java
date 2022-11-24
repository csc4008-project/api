package com.csc4003.apis.Repositories;

import com.csc4003.apis.models.Booking;
import com.csc4003.apis.models.Desk;
import com.csc4003.apis.models.Employee;
import com.csc4003.apis.models.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;
import static org.hibernate.sql.ast.Clause.FROM;

public interface BookingRepository extends CrudRepository<Booking, Integer>
{
    Booking findByEmployee(Employee employee);
    List<Booking> findByRoom(Room room);
    List<Booking> findByDesk(Desk desk);

    @Query("SELECT b FROM Booking b WHERE b.bookingId = :bookingId")
    Booking findBookingDetailsById(int bookingId);

    // Not sure if to add these?
        // Few more queries could be added such as:
        // -Return all room bookings for room name
        // -Return all room bookings for floor number
        // -Return all room bookings for building name
        // -Return all desk bookings for desk name
        // -Return all desk bookings for space name
        // -Return all desk bookings for floor number
        // -Return all desk bookings for building name

}

