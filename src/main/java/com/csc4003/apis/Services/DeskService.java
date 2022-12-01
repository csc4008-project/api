package com.csc4003.apis.Services;

import com.csc4003.apis.Repositories.DeskRepository;
import com.csc4003.apis.models.Desk;
import com.csc4003.apis.models.Space;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeskService {

    @Autowired
    private DeskRepository deskRepository;

    public List<Desk> getAllDesks()
    {
        List<Desk>deskRecords = new ArrayList<>();
        deskRepository.findAll().forEach(deskRecords::add);
        return deskRecords;
    }
    public void addDesk(Desk desk)
    {
        deskRepository.save(desk);
    }

    public void updateDesk(Desk desk)
    {
        deskRepository.save(desk);
    }

    public void deleteDeskById(int deskId) {
        deskRepository.deleteById(deskId);
    }

    public Optional<Desk> findDeskById(int deskId) {
        return deskRepository.findById(deskId);
    }

    public Desk findBySpace(Space space) {
        return deskRepository.findBySpace(space);
    }

    public Desk findDeskDetails() {
        return deskRepository.findDeskDetails();
    }

    // return desks for space
    public List<Desk> findDesksBySpace(Space space) {
        return deskRepository.findDesksBySpace(space);
    }
    
}
