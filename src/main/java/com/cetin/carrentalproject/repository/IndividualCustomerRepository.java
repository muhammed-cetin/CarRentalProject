package com.cetin.carrentalproject.repository;

import com.cetin.carrentalproject.model.IndividualCustomer;
import com.cetin.carrentalproject.model.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndividualCustomerRepository extends CrudRepository<IndividualCustomer, Integer> {
    List<IndividualCustomer> findAllIndividualCustomersById(Rental rental);
}
