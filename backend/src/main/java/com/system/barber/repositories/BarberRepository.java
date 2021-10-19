package com.system.barber.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.system.barber.entities.BarberDetails;

@Repository
public interface BarberRepository extends MongoRepository<BarberDetails, String> {
    BarberDetails findById(long id);

}
