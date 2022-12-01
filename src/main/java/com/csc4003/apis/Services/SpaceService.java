package com.csc4003.apis.Services;

import com.csc4003.apis.Repositories.SpaceRepository;
import com.csc4003.apis.models.Floor;
import com.csc4003.apis.models.Space;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpaceService {

    @Autowired
    private SpaceRepository spaceRepository;

    public List<Space> getAllSpaces()
    {
        List<Space>spaceRecords = new ArrayList<>();
        spaceRepository.findAll().forEach(spaceRecords::add);
        return spaceRecords;
    }
    public void addSpace(Space space)
    {
        spaceRepository.save(space);
    }

    public void updateSpace(Space space)
    {
        spaceRepository.save(space);
    }

    public void deleteSpaceById(int spaceId) {
        spaceRepository.deleteById(spaceId);
    }

    public void findSpaceById(int spaceId) {
        spaceRepository.findById(spaceId);
    }

    public Space findByFloor(Floor floor) {
        return spaceRepository.findByFloor(floor);
    }

    public Space findSpaceDetails() {
        return spaceRepository.findSpaceDetails();
    }

    // pass in floor id return spaces for that floor
    public List<Space> findSpacesByFloor(Floor floor) {
        return spaceRepository.findSpacesByFloor(floor);
    }

}
