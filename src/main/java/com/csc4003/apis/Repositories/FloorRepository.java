package com.csc4003.apis.Repositories;

import com.csc4003.apis.models.Building;
import com.csc4003.apis.models.Floor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FloorRepository extends CrudRepository<Floor, Integer> {

    Floor findByBuilding(Building building);
    @Query("SELECT f FROM Floor f")
    Floor findFloorDetails();

    List<Floor> findFloorsByBuilding(Building building);

}
