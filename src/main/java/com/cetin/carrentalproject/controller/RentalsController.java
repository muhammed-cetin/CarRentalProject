package com.cetin.carrentalproject.controller;


import com.cetin.carrentalproject.dto.requestDto.RentalRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.RentalResponseDto;
import com.cetin.carrentalproject.service.abstracts.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalsController {

    private RentalService rentalService;

    @Autowired
    public RentalsController(RentalService rentalService) {
        super();
        this.rentalService = rentalService;
    }

    @PostMapping("/saveRental")
    public ResponseEntity<Integer> saveRental(@RequestBody RentalRequestDto rentalRequestDto) {
        Integer rentalId = rentalService.saveRental(rentalRequestDto);
        return new ResponseEntity<>(rentalId, HttpStatus.OK);
    }

    @GetMapping("/findAllRentals")
    public ResponseEntity<List<RentalResponseDto>> findAllRentals() {
        List<RentalResponseDto> rentalResponseDtos = rentalService.findAllRentals();
        return new ResponseEntity<>(rentalResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/findAllRentalsById")
    public ResponseEntity<List<RentalResponseDto>> findAllRentalsById(@RequestParam Integer carId) {
        List<RentalResponseDto> rentalResponseDtos = rentalService.findAllRentalsById(carId);
        return new ResponseEntity<>(rentalResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/deleteRentalById")
    public ResponseEntity<Boolean> deleteRentalById(@RequestParam Integer rentalId) {
        boolean delete = rentalService.deleteRentalById(rentalId);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}

