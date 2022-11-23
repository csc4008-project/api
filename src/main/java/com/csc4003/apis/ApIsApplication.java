package com.csc4003.apis;

import com.csc4003.apis.Services.BookingService;
import com.csc4003.apis.models.Employee;
import com.csc4003.apis.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    public static void main(String[] args) {
        SpringApplication.run(ApIsApplication.class, args);
    }
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {

        /* ------- Testing adding a new employee to database
        Employee emp = new Employee(2,"Gary", "Test", "Manager", "JohnDoe@gmail.com", "password");
        employeeService.addEmployee(emp);
        */

        /* ------- Testing getting a query back from database - check BookingDepostiory: String findRoomBookingById(int bookingId);
           ------- below is an example of how to store the returned string from query result, split each field returned and add it to an array.
           ------- Could be useful for future reference with controllers

        String[] elements = bookingService.findRoomBookingById(1).split(",");

        List<String> fixedLengthList = Arrays.asList(elements);

        ArrayList<String> listOfString = new ArrayList<String>(fixedLengthList);

        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("Booking ID: ");
        columnNames.add("Room Name: ");
        columnNames.add("Room Type: ");
        columnNames.add("Floor Number: ");
        columnNames.add("Floor Name: ");
        columnNames.add("Building Name: ");
        columnNames.add("Start Time: ");
        columnNames.add("End Time: ");
        columnNames.add("Duration: ");

        String output = "";
        for (int i=0; i < columnNames.size(); i++){
            output += columnNames.get(i);
            output += listOfString.get(i);
            output += ", \n";
        }

        return output;
        */


        return String.format("Hello %s!", name);

    }

}
