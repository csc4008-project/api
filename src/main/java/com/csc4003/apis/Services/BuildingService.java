package com.csc4003.apis.Services;

import com.csc4003.apis.Repositories.BuildingRepository;
import com.csc4003.apis.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Building> findBuildingById(int buildingId) {
        return buildingRepository.findById(buildingId);
    }

    public Building findBuildingDetails() {
        return buildingRepository.findBuildingDetails();
    }

}
