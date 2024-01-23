package com.cetin.carrentalproject.repository;

import com.cetin.carrentalproject.model.Brand;
import com.cetin.carrentalproject.model.Car;
import com.cetin.carrentalproject.model.FuelType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
    List<Car> findAllCarsByBrandId(Brand brand);
    List<Car> findAllCarsByFuelTypeId(FuelType fuelType);
}
