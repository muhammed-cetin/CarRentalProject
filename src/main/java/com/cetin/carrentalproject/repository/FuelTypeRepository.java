package com.cetin.carrentalproject.repository;

import com.cetin.carrentalproject.model.FuelType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelTypeRepository extends CrudRepository<FuelType, Integer> {

}
