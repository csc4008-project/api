package com.csc4003.apis.Repositories;

import com.csc4003.apis.models.Floor;
import com.csc4003.apis.models.Space;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpaceRepository extends CrudRepository<Space, Integer> {

    Space findByFloor(Floor floor);

    @Query("SELECT s FROM Space s")
    Space findSpaceDetails();

    List<Space> findSpacesByFloor(Floor floor);


}
