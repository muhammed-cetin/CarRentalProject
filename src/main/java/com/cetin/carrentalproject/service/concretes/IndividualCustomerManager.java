package com.cetin.carrentalproject.service.concretes;

import com.cetin.carrentalproject.dto.requestDto.IndividualCustomerRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.IndividualCustomerResponseDto;
import com.cetin.carrentalproject.model.IndividualCustomer;
import com.cetin.carrentalproject.model.Rental;
import com.cetin.carrentalproject.repository.IndividualCustomerRepository;
import com.cetin.carrentalproject.repository.RentalRepository;
import com.cetin.carrentalproject.service.abstracts.IndividualCustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndividualCustomerManager implements IndividualCustomerService {

    @Autowired
    private IndividualCustomerRepository individualCustomerRepository;
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Integer saveIndividualCustomer(IndividualCustomerRequestDto individualCustomerRequestDto) {
        IndividualCustomer individualCustomer = modelMapper.map(individualCustomerRequestDto, IndividualCustomer.class);
        individualCustomer = individualCustomerRepository.save(individualCustomer);
        return individualCustomer.getId();
    }

    @Override
    public List<IndividualCustomerResponseDto> findAllIndividualCustomers() {
        Iterable<IndividualCustomer> individualCustomerList = individualCustomerRepository.findAll();

        List<IndividualCustomerResponseDto> individualCustomerResponseDtos = new ArrayList<>();
        for (IndividualCustomer individualCustomer : individualCustomerList) {
            IndividualCustomerResponseDto individualCustomerResponseDto = modelMapper.map(individualCustomer, IndividualCustomerResponseDto.class);
            individualCustomerResponseDtos.add(individualCustomerResponseDto);
        }
        return individualCustomerResponseDtos;

    }

    @Override
    public List<IndividualCustomerResponseDto> findAllIndividualCustomersById(Integer rentalId) {
        Rental rental = rentalRepository.findById(rentalId).get();
        List<IndividualCustomer> individualCustomerList = individualCustomerRepository
                .findAllIndividualCustomersById(rental);

        List<IndividualCustomerResponseDto> individualCustomerResponseDtos = new ArrayList<>();
        for (IndividualCustomer individualCustomer : individualCustomerList) {
            IndividualCustomerResponseDto individualCustomerResponseDto = modelMapper.map(individualCustomer, IndividualCustomerResponseDto.class);
            individualCustomerResponseDtos.add(individualCustomerResponseDto);
        }
        return individualCustomerResponseDtos;
    }

    @Override
    public boolean deleteIndividualCustomerById(Integer individualCustomerId) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(individualCustomerId).get();
        individualCustomerRepository.delete(individualCustomer);
        return true;
    }

}
