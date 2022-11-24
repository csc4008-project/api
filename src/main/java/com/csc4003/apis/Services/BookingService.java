package com.csc4003.apis.Services;

import com.csc4003.apis.Repositories.BookingRepository;
import com.csc4003.apis.models.Booking;
import com.csc4003.apis.models.Desk;
import com.csc4003.apis.models.Employee;
import com.csc4003.apis.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService
{
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings()
    {
        List<Booking>bookingRecords = new ArrayList<>();
        bookingRepository.findAll().forEach(bookingRecords::add);
        return bookingRecords;
    }
    public void addBooking(Booking booking)
    {
        bookingRepository.save(booking);
    }

    public void updateBooking(Booking booking)
    {
        bookingRepository.save(booking);
    }

    public void deleteBookingById(int bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public void findBookingById(int bookingId) {
        bookingRepository.findById(bookingId);
    }

    public Booking findByEmployee(Employee employee) {
        return bookingRepository.findByEmployee(employee);
    }

    public List<Booking> findByRoom(Room room) {
        return bookingRepository.findByRoom(room);
    }

    public List<Booking> findByDesk(Desk desk) {
        return bookingRepository.findByDesk(desk);
    }

    public Booking findBookingDetailsById(int bookingId) {
        return bookingRepository.findBookingDetailsById(bookingId);
    }
}
