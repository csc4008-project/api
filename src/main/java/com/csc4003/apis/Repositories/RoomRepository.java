package com.csc4003.apis.Repositories;

import com.csc4003.apis.models.Room;
import com.csc4003.apis.models.Floor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Integer> {

    Floor findByFloor(Floor floor);

    @Query("SELECT r FROM Room r")
    Room findRoomDetails();
    
}
