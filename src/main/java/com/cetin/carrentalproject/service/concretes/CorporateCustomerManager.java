package com.cetin.carrentalproject.service.concretes;

import com.cetin.carrentalproject.dto.requestDto.CorporateCustomerRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.CorporateCustomerResponseDto;
import com.cetin.carrentalproject.model.CorporateCustomer;
import com.cetin.carrentalproject.model.Rental;
import com.cetin.carrentalproject.repository.CorporateCustomerRepository;
import com.cetin.carrentalproject.repository.RentalRepository;
import com.cetin.carrentalproject.service.abstracts.CorporateCustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CorporateCustomerManager implements CorporateCustomerService {

    @Autowired
    private CorporateCustomerRepository corporateCustomerRepository;
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Integer saveCorporateCustomer(CorporateCustomerRequestDto corporateCustomerRequestDto) {
        CorporateCustomer corporateCustomer = modelMapper.map(corporateCustomerRequestDto, CorporateCustomer.class);
        corporateCustomer = corporateCustomerRepository.save(corporateCustomer);
        return corporateCustomer.getId();
    }

    @Override
    public List<CorporateCustomerResponseDto> findAllCorporateCustomers() {
        Iterable<CorporateCustomer> corporateCustomerList = corporateCustomerRepository.findAll();

        List<CorporateCustomerResponseDto> corporateCustomerResponseDtos = new ArrayList<>();
        for (CorporateCustomer corporateCustomer : corporateCustomerList) {
            CorporateCustomerResponseDto corporateCustomerResponseDto = modelMapper.map(corporateCustomer, CorporateCustomerResponseDto.class);
            corporateCustomerResponseDtos.add(corporateCustomerResponseDto);
        }
        return corporateCustomerResponseDtos;
    }

    @Override
    public List<CorporateCustomerResponseDto> findAllCorporateCustomersById(Integer rentalId) {
        Rental rental = rentalRepository.findById(rentalId).get();
        List<CorporateCustomer> corporateCustomerList = corporateCustomerRepository
                .findAllCorporateCustomersById(rental);

        List<CorporateCustomerResponseDto> corporateCustomerResponseDtos = new ArrayList<>();
        for (CorporateCustomer corporateCustomer : corporateCustomerList) {
            CorporateCustomerResponseDto corporateCustomerResponseDto = modelMapper.map(corporateCustomer, CorporateCustomerResponseDto.class);
            corporateCustomerResponseDtos.add(corporateCustomerResponseDto);
        }
        return corporateCustomerResponseDtos;
    }

    @Override
    public boolean deleteCorporateCustomerById(Integer corporateCustomerId) {
        CorporateCustomer corporateCustomer = corporateCustomerRepository.findById(corporateCustomerId).get();
        corporateCustomerRepository.delete(corporateCustomer);
        return true;
    }

}
