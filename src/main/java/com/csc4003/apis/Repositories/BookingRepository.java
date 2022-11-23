package com.csc4003.apis.Repositories;

import com.csc4003.apis.models.Booking;
import com.csc4003.apis.models.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import static org.hibernate.loader.Loader.SELECT;
import static org.hibernate.sql.ast.Clause.FROM;

public interface BookingRepository extends CrudRepository<Booking, Integer>
{
    Booking findByEmployeeId(int employeeId);
    List<Booking> findByRoomId(int roomId);
    List<Booking> findByDeskId(int deskId);

    // 2 queries below still need to return attendee list (will be added at a later date)
    // end time also needs to be added to the queries below (start_time + duration)
    @Query("SELECT bo.bookingId, r.roomName, r.roomType, f.floorNumber, f.floorName, bu.buildingName, bo.startTime," +
            "bo.duration FROM Booking bo INNER JOIN bo.room r INNER JOIN r.floor f INNER JOIN f.building bu WHERE bo.bookingId = :bookingId")
    String findRoomBookingById(int bookingId);

    @Query("SELECT bo.bookingId, d.deskName, s.spaceName, s.spaceType, f.floorNumber, f.floorName, bu.buildingName, bo.startTime," +
            "bo.duration FROM Booking bo INNER JOIN bo.desk d INNER JOIN d.space s INNER JOIN s.floor f INNER JOIN f.building bu WHERE bo.bookingId = :bookingId")
    String findDeskBookingById(int bookingId);

    // few more queries need to be added such as :
    // --Return all room bookings for room name
    //      return booking id, room name, room type, floor number, floor name, building name, start time, end time, duration
    //
    // --Return all room bookings for floor number
    //      return booking id, room name, room type, floor number, floor name, building name, start time, end time, duration
    //
    // --Return all room bookings for building name
    //      return booking id, room name, room type, floor number, floor name, building name, start time, end time, duration

    // --Return all desk bookings for desk name
    //      return booking id, desk name, space name, space type, floor number, floor name, building name, start time, end time, duration
    //
    // --Return all desk bookings for space name
    //      return booking id, desk name, space name, space type, floor number, floor name, building name, start time, end time, duration
    //
    // --Return all desk bookings for floor number
    //      return booking id, desk name, space name, space type, floor number, floor name, building name, start time, end time, duration
    //
    // --Return all desk bookings for building name
    //      return booking id, desk name, space name, space type, floor number, floor name, building name, start time, end time, duration

}

