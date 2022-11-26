package com.csc4003.apis.Repositories;

import com.csc4003.apis.models.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BuildingRepository extends CrudRepository<Building, Integer>
{

    @Query("SELECT b FROM Building b")
    Building findBuildingDetails();

}

