package com.cetin.carrentalproject.service.concretes;

import com.cetin.carrentalproject.dto.responseDtos.CustomerResponseDto;
import com.cetin.carrentalproject.model.Customer;
import com.cetin.carrentalproject.repository.CustomerRepository;
import com.cetin.carrentalproject.service.abstracts.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerManager implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CustomerResponseDto> findAllCustomers() {
        Iterable<Customer> customerList = customerRepository.findAll();

        List<CustomerResponseDto> customerResponseDtos = new ArrayList<>();
        for (Customer customer : customerList) {
            CustomerResponseDto customerResponseDto = modelMapper.map(customer, CustomerResponseDto.class);
            customerResponseDtos.add(customerResponseDto);
        }
        return customerResponseDtos;
    }

}
