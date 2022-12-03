package com.csc4003.apis;

import com.csc4003.apis.Services.*;
import com.csc4003.apis.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.Book;
import java.sql.Timestamp;
import java.util.*;

@RestController
public class BookingController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private AttendeeService attendeeService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private FloorService floorService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private SpaceService spaceService;
    @Autowired
    private DeskService deskService;

    @CrossOrigin
    @GetMapping("/booking")
    public String getBooking(@RequestParam(value = "userId") String test) {
        return test;
        //return new Booking(bookingId, employeeId, room, deskId, startTime, duration);
    }

    @CrossOrigin
    @GetMapping("/listBookings")
    public Map<String, Object> listBookings(@RequestHeader(HttpHeaders.AUTHORIZATION) String auth) {
        if(JWTAuth.authJWT(auth.split(" ")[1])) {
            Employee emp = employeeService.findByEmail(JWTAuth.getEmailFromJWT(auth.split(" ")[1]));

            List<Booking> bookings = bookingService.findAllBookingsByEmployee(emp);

            List<Attendee> attendees = attendeeService.findAttendedBookingsByEmployee(emp);

            for(Attendee att : attendees) {
                bookings.add(att.getBooking());
            }

            HashMap<String, Object> outerIDMap = new HashMap<>();

            for(Booking booking: bookings) {
                HashMap<String, Object> bookingJson = new HashMap<>();

                bookingJson.put("start_time", booking.getStartTime().toString());
                bookingJson.put("duration", booking.getDuration());
                bookingJson.put("attendees", attendeeService.findAttendeesByBooking(booking.getBookingId()));
                bookingJson.put("room", booking.getRoom());
                bookingJson.put("desk", booking.getDesk());
                bookingJson.put("employee", booking.getEmployee());

                outerIDMap.put(Integer.toString(booking.getBookingId()), bookingJson);
            }

            HashMap<String, Object> outerWrapper = new HashMap<>();

            outerWrapper.put("booking", outerIDMap);

            return outerWrapper;
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "User is not authorised to make API calls"
            );
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteBooking", method = RequestMethod.DELETE)
    public ResponseEntity deleteBooking(@RequestBody Map<String, Object> json, @RequestHeader(HttpHeaders.AUTHORIZATION) String auth) {
        if(JWTAuth.authJWT(auth.split(" ")[1])) {
            Booking booking = bookingService.findBookingDetailsById(Integer.parseInt(json.get("booking_id").toString()));

            if(booking.getEmployeeEmail().equals(JWTAuth.getEmailFromJWT(auth))) {
                bookingService.deleteBookingById(Integer.parseInt(json.get("booking_id").toString()));

                return ResponseEntity.ok("Booking successfully deleted");
            }

            else {
                throw new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "User did not create this booking"
                );
            }
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "User is not authorised to make API calls"
            );
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/findBuildings", method = RequestMethod.GET)
    public Map<String, Object> findBuildings(@RequestHeader(HttpHeaders.AUTHORIZATION) String auth) {
        if(JWTAuth.authJWT(auth.split(" ")[1])) {
            List<Building> buildings = buildingService.getAllBuildings();

            HashMap<String, HashMap<String, String>> outerIDMap = new HashMap<>();

            for(Building build : buildings) {
                HashMap<String, String> buildingJson = new HashMap<>();

                buildingJson.put("buildingName", build.getBuildingName());
                buildingJson.put("buildingShortCode", build.getBuildingShortCode());
                buildingJson.put("addressLine1", build.getAddressLine1());
                buildingJson.put("addressLine2", build.getAddressLine2());
                buildingJson.put("postcode", build.getPostcode());
                buildingJson.put("city", build.getCity());
                buildingJson.put("county", build.getCounty());
                buildingJson.put("country", build.getCountry());

                outerIDMap.put(Integer.toString(build.getBuildingId()), buildingJson);
            }

            HashMap<String, Object> outerWrapper = new HashMap<>();

            outerWrapper.put("buildings", outerIDMap);

            return outerWrapper;
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "User is not authorised to make API calls"
            );
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/findFloors", method = RequestMethod.GET)
    public Map<String, Object> findFloors(@RequestBody Map<String, Object> json, @RequestHeader(HttpHeaders.AUTHORIZATION) String auth) {
        if(JWTAuth.authJWT(auth.split(" ")[1])) {

            Building building = buildingService.findBuildingById(Integer.parseInt(json.get("building_id").toString())).get();
            List<Floor> floors = floorService.findFloorsByBuilding(building);

            //needs return floors for a given building ID
            HashMap<String, Object> outerIDMap = new HashMap<>();

            for(Floor floor: floors) {
                HashMap<String, Object> floorJson = new HashMap<>();

                floorJson.put("floorNumber", floor.getFloorNumber());
                floorJson.put("building", floor.getBuilding());

                outerIDMap.put(Integer.toString(floor.getFloorId()), floorJson);
            }

            HashMap<String, Object> outerWrapper = new HashMap<>();
            outerWrapper.put("floors", outerIDMap);
            return outerWrapper;
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "User is not authorised to make API calls"
            );
        }
    }

    @CrossOrigin
    @GetMapping("/listSpaces")
    public Map<String, Object> listSpaces(@RequestBody Map<String, Object> json, @RequestHeader(HttpHeaders.AUTHORIZATION) String auth) {
        if(JWTAuth.authJWT(auth.split(" ")[1])) {
            Floor floor = floorService.findFloorById(Integer.parseInt(json.get("floor_id").toString())).get();
            List<Space> spaces = spaceService.findSpacesByFloor(floor);

            HashMap<String, Object> outerIDMap = new HashMap<>();

            for(Space space : spaces) {
                HashMap<String, Object> spaceJson = new HashMap<>();

                spaceJson.put("spaceName", space.getSpaceName());
                spaceJson.put("spaceType", space.getSpaceType());
                spaceJson.put("deskCapacity", space.getDeskCapacity());
                spaceJson.put("floor", space.getFloor());

                outerIDMap.put(Integer.toString(space.getSpaceId()), spaceJson);
            }

            HashMap<String, Object> outerWrapper = new HashMap<>();

            outerWrapper.put("spaces", outerIDMap);

            return outerWrapper;
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "User is not authorised to make API calls"
            );
        }
    }

    @CrossOrigin
    @GetMapping("/listRooms")
    public Map<String, Object> listRooms(@RequestBody Map<String, Object> json, @RequestHeader(HttpHeaders.AUTHORIZATION) String auth) {
        if(JWTAuth.authJWT(auth.split(" ")[1])) {
            Floor floor = floorService.findFloorById(Integer.parseInt(json.get("floor_id").toString())).get();
            List<Room> rooms = roomService.findRoomsByFloor(floor);

            HashMap<String, Object> outerIDMap = new HashMap<>();

            for(Room room : rooms) {
                HashMap<String, Object> roomJson = new HashMap<>();

                roomJson.put("roomNumber", room.getRoomNumber());
                roomJson.put("roomType", room.getRoomType());
                roomJson.put("capacity", room.getCapacity());
                roomJson.put("floor", room.getFloor());


                outerIDMap.put(Integer.toString(room.getRoomId()), roomJson);
            }

            HashMap<String, Object> outerWrapper = new HashMap<>();

            outerWrapper.put("rooms", outerIDMap);

            return outerWrapper;
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "User is not authorised to make API calls"
            );
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/createBooking", method = RequestMethod.PUT)
    public ResponseEntity createBooking(@RequestBody Map<String, Object> json, @RequestHeader(HttpHeaders.AUTHORIZATION) String auth) {
        if(JWTAuth.authJWT(auth.split(" ")[1])) {
            Employee emp = employeeService.findByEmail(JWTAuth.getEmailFromJWT(auth.split(" ")[1]));
            if(json.get("desk_id") != null) {
                Booking booking = new Booking(emp, null, deskService.findDeskById(Integer.parseInt(json.get("desk_id").toString())).get(), Timestamp.valueOf(json.get("start").toString()), Integer.parseInt(json.get("duration").toString()));

                ObjectMapper objectMapper = new ObjectMapper();
                List<Employee> attendees = new ArrayList<>();
                try {
                    attendees = Arrays.asList(objectMapper.readValue(json.get("attendees").toString(), Employee[].class));
                }
                catch (Exception e) {

                }

                for(Employee att : attendees) {
                    Attendee at = new Attendee(booking, att);
                    attendeeService.addAttendee(at);
                }
            } else if (json.get("room_id") != null) {
                Booking booking = new Booking(emp, roomService.findRoomById(Integer.parseInt(json.get("room_id").toString())).get(), null, Timestamp.valueOf(json.get("start").toString()), Integer.parseInt(json.get("duration").toString()));

                ObjectMapper objectMapper = new ObjectMapper();
                List<Employee> attendees = new ArrayList<>();
                try {
                    attendees = Arrays.asList(objectMapper.readValue(json.get("attendees").toString(), Employee[].class));
                }
                catch (Exception e) {

                }

                for(Employee att : attendees) {
                    Attendee at = new Attendee(booking, att);
                    attendeeService.addAttendee(at);
                }
            }
           return ResponseEntity.ok("Booking successfully created");
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "User is not authorised to make API calls"
            );
        }
    }
}
