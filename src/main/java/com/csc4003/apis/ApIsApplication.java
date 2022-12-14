package com.csc4003.apis;

import com.csc4003.apis.Services.*;
import com.csc4003.apis.models.Attendee;
import com.csc4003.apis.models.Booking;
import com.csc4003.apis.models.Building;
import com.csc4003.apis.models.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.*;

@SpringBootApplication
@RestController
public class ApIsApplication {

    // need to add these into the controllers so you can access SQL queries
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private AttendeeService attendeeService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private RoomService roomService;

    public static void main(String[] args) {
        SpringApplication.run(ApIsApplication.class, args);
    }
    @GetMapping("/hello")
    public void sayHello() {

//        Booking booking = new Booking(employeeService.findEmployeeById(1).get(),roomService.findRoomById(1).get(),null, Timestamp.valueOf("2022-12-03 23:07:09"), 60);
//        System.out.println(booking.toString());
//        bookingService.addBooking(booking);
//
//        Attendee att = new Attendee(bookingService.findBookingDetailsById(1), employeeService.findEmployeeById(2).get());
//        System.out.println(att.toString());
//        attendeeService.addAttendee(att);



//        Employee emp = new Employee("Test Name", "Test", "emailtest", "test");
//        Building building = buildingService.findBuildingById(1).get();
//
//        ObjectMapper mapper = new ObjectMapper();
//        List<Integer> json = new ArrayList<>();
//        String testArray = "[1,2,3,4,5]";
//        try {
//            json = Arrays.asList(mapper.readValue(testArray, Integer[].class));
//        }
//        catch (Exception e) {
//
//        }
//        HashMap<String, Object> test = new HashMap<>();
//        test.put("Super Title Test", "Test Data");
//        test.put("test", json);

//        String test = "Test" + null;
//        Booking booking = bookingService.findBookingDetailsById(1);
//        Employee employee = employeeService.findEmployeeById(1).get();
//        Attendee att = new Attendee(booking, employee);
//        attendeeService.addAttendee(att);
    }

}
