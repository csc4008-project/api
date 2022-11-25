package com.csc4003.apis.Services;

import com.csc4003.apis.Repositories.FloorRepository;
import com.csc4003.apis.models.Building;
import com.csc4003.apis.models.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FloorService {

    @Autowired
    private FloorRepository floorRepository;

    public List<Floor> getAllFloors()
    {
        List<Floor>floorRecords = new ArrayList<>();
        floorRepository.findAll().forEach(floorRecords::add);
        return floorRecords;
    }
    public void addFloor(Floor floor)
    {
        floorRepository.save(floor);
    }

    public void updateFloor(Floor floor)
    {
        floorRepository.save(floor);
    }

    public void deleteFloorById(int floorId) {
        floorRepository.deleteById(floorId);
    }

    public void findFloorById(int floorId) {
        floorRepository.findById(floorId);
    }

    public Building findByBuilding(Building building) {
        return floorRepository.findByBuilding(building);
    }

    public Floor findFloorDetails() {
        return floorRepository.findFloorDetails();
    }
}
