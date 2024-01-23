package com.cetin.carrentalproject.repository;

import com.cetin.carrentalproject.model.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceCorporateCustomerRepository extends CrudRepository<Invoice, Integer> {

}
