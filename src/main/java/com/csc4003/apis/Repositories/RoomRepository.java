package com.csc4003.apis.Repositories;

import com.csc4003.apis.models.Room;
import com.csc4003.apis.models.Floor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Integer> {

    Room findByFloor(Floor floor);

    @Query("SELECT r FROM Room r")
    Room findRoomDetails();

    List<Room> findRoomsByFloor(Floor floor);
    
}
