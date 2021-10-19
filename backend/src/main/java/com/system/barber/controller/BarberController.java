package com.system.barber.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.barber.entities.BarberDetails;
import com.system.barber.services.BarberService;

@RestController
@RequestMapping("/barber")
public class BarberController {

    @Autowired
    BarberService barberService;

    @PostMapping("/register")
    public ResponseEntity<?> createBarberRecord(@RequestBody BarberDetails barberDetails) {
        try {
            return new ResponseEntity<>(barberService.registerBarberDetails(barberDetails), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/details")
    public ResponseEntity<?> getBarberAllRecords() {
        try {
            return new ResponseEntity<>(barberService.getBarberAllRecords(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<?> getBarberRecord(@PathVariable long id) {
        try {
            return new ResponseEntity<>(barberService.getBarberRecord(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
