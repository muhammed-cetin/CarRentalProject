package com.cetin.carrentalproject.controller;


import com.cetin.carrentalproject.dto.requestDto.FuelTypeRequestDto;
import com.cetin.carrentalproject.service.abstracts.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fuelTypes")
public class FuelTypesController {

    private FuelTypeService fuelTypeService;

    @Autowired
    public FuelTypesController(FuelTypeService fuelTypeService) {
        super();
        this.fuelTypeService = fuelTypeService;
    }

    @PostMapping("/saveFuelType")
    public ResponseEntity<Integer> saveFuelType(@RequestBody FuelTypeRequestDto fuelTypeRequestDto) {
        Integer fuelTypeId = fuelTypeService.saveFuelType(fuelTypeRequestDto);
        return new ResponseEntity<>(fuelTypeId, HttpStatus.OK);
    }
}

