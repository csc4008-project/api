package com.csc4003.apis.Services;

import com.csc4003.apis.Repositories.BuildingRepository;
import com.csc4003.apis.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public List<Building> getAllBuildings()
    {
        List<Building>buildingRecords = new ArrayList<>();
        buildingRepository.findAll().forEach(buildingRecords::add);
        return buildingRecords;
    }
    public void addBuilding(Building building)
    {
        buildingRepository.save(building);
    }

    public void updateBuilding(Building building)
    {
        buildingRepository.save(building);
    }

    public void deleteBuildingById(int buildingId) {
        buildingRepository.deleteById(buildingId);
    }

    public void findBuildingById(int buildingId) {
        buildingRepository.findById(buildingId);
    }

    public Building findBuildingDetails() {
        return buildingRepository.findBuildingDetails();
    }

}
