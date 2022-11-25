package com.csc4003.apis.Repositories;

import com.csc4003.apis.models.Building;
import com.csc4003.apis.models.Floor;
import com.csc4003.apis.models.Space;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SpaceRepository extends CrudRepository<Space, Integer> {

    Floor findByFloor(Floor floor);

    @Query("SELECT s FROM Space s")
    Space findSpaceDetails();


}
