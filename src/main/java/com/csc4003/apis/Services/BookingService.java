package com.csc4003.apis.Services;

import com.csc4003.apis.Repositories.BookingRepository;
import com.csc4003.apis.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Booking findByEmployeeId(int employeeId) {
        return bookingRepository.findByEmployeeId(employeeId);
    }

    public List<Booking> findByRoomId(int roomId) {
        return bookingRepository.findByRoomId(roomId);
    }

    public List<Booking> findByDeskId(int deskId) {
        return bookingRepository.findByDeskId(deskId);
    }

    public String findRoomBookingById(int bookingId) {
        return bookingRepository.findRoomBookingById(bookingId);
    }
}
