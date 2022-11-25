package com.csc4003.apis;

import com.csc4003.apis.Services.AttendeeService;
import com.csc4003.apis.Services.BookingService;
import com.csc4003.apis.models.Booking;
import com.csc4003.apis.models.Employee;
import com.csc4003.apis.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static void main(String[] args) {
        SpringApplication.run(ApIsApplication.class, args);
    }
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {

        /* ------- Testing adding a new employee to database
        Employee emp = new Employee(2,"Gary Johnson", "Manager", "JohnDoe@gmail.com", "password");
        employeeService.addEmployee(emp);
        */

        // ------- Testing outputting some booking data
        //String buildingName = bookingService.findBookingDetailsById(1).getRoom().getRoomNumber();
        //return ""+bookingService.findBookingDetailsById(1).getEmployee().getEmployeeId();

        // ------- Testing outputting some booking attendee data
        //return attendeeService.findAttendeesByBooking(1).get(0).getEmployeeEmail() + " and + attendeeService.findAttendeesByBooking(1).get(1).getEmployeeEmail();

        return String.format("Hello %s!", name);

    }

}
