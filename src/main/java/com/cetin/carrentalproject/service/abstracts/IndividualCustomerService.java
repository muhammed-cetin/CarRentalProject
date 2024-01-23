package com.cetin.carrentalproject.service.abstracts;

import com.cetin.carrentalproject.dto.requestDto.IndividualCustomerRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.IndividualCustomerResponseDto;

import java.util.List;

public interface IndividualCustomerService {
    Integer saveIndividualCustomer(IndividualCustomerRequestDto individualCustomerRequestDto);

    List<IndividualCustomerResponseDto> findAllIndividualCustomers();

    List<IndividualCustomerResponseDto> findAllIndividualCustomersById(Integer rentalId);

    boolean deleteIndividualCustomerById(Integer individualCustomerId);
}
