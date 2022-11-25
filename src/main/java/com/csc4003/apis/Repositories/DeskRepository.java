package com.csc4003.apis.Repositories;

import com.csc4003.apis.models.Desk;
import com.csc4003.apis.models.Space;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DeskRepository extends CrudRepository<Desk, Integer> {

    Space findBySpace(Space space);

    @Query("SELECT d FROM Desk d")
    Desk findDeskDetails();

}
