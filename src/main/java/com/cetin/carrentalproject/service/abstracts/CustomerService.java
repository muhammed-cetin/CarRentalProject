package com.cetin.carrentalproject.service.abstracts;

import com.cetin.carrentalproject.dto.responseDtos.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDto> findAllCustomers();
}
