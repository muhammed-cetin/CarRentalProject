package com.cetin.carrentalproject.service.abstracts;

import com.cetin.carrentalproject.dto.requestDto.InvoiceCorporateCustomerRequestDto;
import com.cetin.carrentalproject.dto.requestDto.InvoiceIndividualCustomerRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.InvoiceResponseDto;

import java.util.List;

public interface InvoiceService {
    Integer saveInvoiceCorporateCustomer(InvoiceCorporateCustomerRequestDto invoiceCorporateCustomerRequestDto);

    Integer saveInvoiceIndividualCustomer(InvoiceIndividualCustomerRequestDto invoiceIndividualCustomerRequestDto);

    List<InvoiceResponseDto> findAllInvoices();

    List<InvoiceResponseDto> findAllInvoicesByCorporateCustomerId(Integer CorporateCustomerId);

    List<InvoiceResponseDto> findAllInvoicesByIndividualCustomerId(Integer IndividualCustomerId);

    boolean deleteInvoiceById(Integer invoiceId);
}
