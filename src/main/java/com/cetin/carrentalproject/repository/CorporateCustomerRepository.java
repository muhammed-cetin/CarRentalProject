package com.cetin.carrentalproject.repository;

import com.cetin.carrentalproject.model.CorporateCustomer;
import com.cetin.carrentalproject.model.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorporateCustomerRepository extends CrudRepository<CorporateCustomer, Integer> {
    List<CorporateCustomer> findAllCorporateCustomersById(Rental rental);
}