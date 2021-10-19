package com.system.barber.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.barber.entities.BarberDetails;
import com.system.barber.repositories.BarberRepository;

@Service
public class BarberService {

    @Autowired
    BarberRepository barberRepository;

    public BarberDetails registerBarberDetails(BarberDetails barberDetails) {
        barberDetails.setId(generateRandomId());
        return barberRepository.save(barberDetails);
    }

    public List<BarberDetails> getBarberAllRecords() {
        List<BarberDetails> barberDetailsList = barberRepository.findAll();
        Comparator<BarberDetails> comparator = Comparator.comparing(BarberDetails::getId);
        Collections.sort(barberDetailsList, comparator);
        return barberDetailsList;
    }

    public BarberDetails getBarberRecord(long id) {
        return barberRepository.findById(id);
    }

    private long generateRandomId(){
        Random rand = new Random();
        // Generate random id in range 0 to 999
        return rand.nextInt(1000);
    }
}
