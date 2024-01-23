package com.cetin.carrentalproject.repository;

import com.cetin.carrentalproject.model.Car;
import com.cetin.carrentalproject.model.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends CrudRepository<Rental, Integer> {
    List<Rental> findAllByCarId(Car car);
}
