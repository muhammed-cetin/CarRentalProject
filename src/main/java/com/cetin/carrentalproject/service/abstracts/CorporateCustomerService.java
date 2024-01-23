package com.cetin.carrentalproject.service.abstracts;

import com.cetin.carrentalproject.dto.requestDto.CorporateCustomerRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.CorporateCustomerResponseDto;

import java.util.List;

public interface CorporateCustomerService {
    Integer saveCorporateCustomer(CorporateCustomerRequestDto corporateCustomerRequestDto);

    List<CorporateCustomerResponseDto> findAllCorporateCustomers();

    List<CorporateCustomerResponseDto> findAllCorporateCustomersById(Integer rentalId);

    boolean deleteCorporateCustomerById(Integer corporateCustomerId);
}
