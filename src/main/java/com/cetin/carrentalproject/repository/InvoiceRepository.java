package com.cetin.carrentalproject.repository;

import com.cetin.carrentalproject.model.CorporateCustomer;
import com.cetin.carrentalproject.model.IndividualCustomer;
import com.cetin.carrentalproject.model.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {
    List<Invoice> findAllInvoicesByCorporateCustomerId(CorporateCustomer corporateCustomer);

    List<Invoice> findAllInvoicesByIndividualCustomerId(IndividualCustomer individualCustomer);
}
