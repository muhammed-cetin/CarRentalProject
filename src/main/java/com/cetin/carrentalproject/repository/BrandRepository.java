package com.cetin.carrentalproject.repository;

import com.cetin.carrentalproject.model.Brand;
import com.cetin.carrentalproject.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {
    List<Brand> findAllBrandsById(Car car);

}
