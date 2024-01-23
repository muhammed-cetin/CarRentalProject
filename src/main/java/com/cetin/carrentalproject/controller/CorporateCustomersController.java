package com.cetin.carrentalproject.controller;


import com.cetin.carrentalproject.dto.requestDto.CorporateCustomerRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.CorporateCustomerResponseDto;
import com.cetin.carrentalproject.service.abstracts.CorporateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corporateCustomers")
public class CorporateCustomersController {

    private CorporateCustomerService corporateCustomerService;

    @Autowired
    public CorporateCustomersController(CorporateCustomerService corporateCustomerService) {
        super();
        this.corporateCustomerService = corporateCustomerService;
    }

    @PostMapping("/saveCorporateCustomer")
    public ResponseEntity<Integer> saveCorporateCustomer(@RequestBody CorporateCustomerRequestDto corporateCustomerRequestDto) {
        Integer corporateCustomerId = corporateCustomerService.saveCorporateCustomer(corporateCustomerRequestDto);
        return new ResponseEntity<>(corporateCustomerId, HttpStatus.OK);
    }

    @GetMapping("/findAllCorporateCustomers")
    public ResponseEntity<List<CorporateCustomerResponseDto>> findAllCorporateCustomers() {
        List<CorporateCustomerResponseDto> corporateCustomerResponseDtos = corporateCustomerService.findAllCorporateCustomers();
        return new ResponseEntity<>(corporateCustomerResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/findAllCorporateCustomersById")
    public ResponseEntity<List<CorporateCustomerResponseDto>> findAllCorporateCustomersById(@RequestParam Integer rentalId) {
        List<CorporateCustomerResponseDto> corporateCustomerResponseDtos = corporateCustomerService.findAllCorporateCustomersById(rentalId);
        return new ResponseEntity<>(corporateCustomerResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCorporateCustomerById")
    public ResponseEntity<Boolean> deleteCorporateCustomerById(@RequestParam Integer corporateCustomerId) {
        boolean delete = corporateCustomerService.deleteCorporateCustomerById(corporateCustomerId);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

}
