package com.csc4003.apis.Repositories;

import com.csc4003.apis.models.Desk;
import com.csc4003.apis.models.Space;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeskRepository extends CrudRepository<Desk, Integer> {

    Desk findBySpace(Space space);

    @Query("SELECT d FROM Desk d")
    Desk findDeskDetails();

    List<Desk> findDesksBySpace(Space space);

}
