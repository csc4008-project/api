package com.csc4003.apis.Services;

import com.csc4003.apis.Repositories.RoomRepository;
import com.csc4003.apis.models.Room;
import com.csc4003.apis.models.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms()
    {
        List<Room>roomRecords = new ArrayList<>();
        roomRepository.findAll().forEach(roomRecords::add);
        return roomRecords;
    }
    public void addRoom(Room room)
    {
        roomRepository.save(room);
    }

    public void updateRoom(Room room)
    {
        roomRepository.save(room);
    }

    public void deleteRoomById(int roomId) {
        roomRepository.deleteById(roomId);
    }

    public void findRoomById(int roomId) {
        roomRepository.findById(roomId);
    }

    public Room findByFloor(Floor floor) {
        return roomRepository.findByFloor(floor);
    }

    public Room findRoomDetails() {
        return roomRepository.findRoomDetails();
    }

    // return list of rooms for floor
    public List<Room> findRoomsByFloor(Floor floor) {
        return roomRepository.findRoomsByFloor(floor);
    }

}
