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

    public static void main(String[] args) {
        SpringApplication.run(ApIsApplication.class, args);
    }
    @GetMapping("/hello")
    public Map<String, Object> sayHello() {

        Employee emp = new Employee("Test Name", "Test", "emailtest", "test");

        HashMap<String, Object> test = new HashMap<>();
        test.put("test", emp);

        return test;

    }

}
