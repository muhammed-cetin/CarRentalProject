package com.cetin.carrentalproject.repository;

import com.cetin.carrentalproject.model.Car;
import com.cetin.carrentalproject.model.CarDamage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDamageRepository extends CrudRepository<CarDamage, Integer> {
    List<CarDamage> findAllCarDamagesById(Car car);
}

