package com.csc4003.apis.Repositories;

import com.csc4003.apis.models.Booking;
import com.csc4003.apis.models.Building;
import com.csc4003.apis.models.Employee;
import com.csc4003.apis.models.Floor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FloorRepository extends CrudRepository<Floor, Integer> {

    Building findByBuilding(Building building);
    @Query("SELECT f FROM Floor f")
    Floor findFloorDetails();

}
