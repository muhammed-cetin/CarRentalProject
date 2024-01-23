package com.cetin.carrentalproject.controller;


import com.cetin.carrentalproject.dto.requestDto.CarRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.CarResponseDto;
import com.cetin.carrentalproject.service.abstracts.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsController {

    private CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        super();
        this.carService = carService;
    }

    @PostMapping("/saveCar")
    public ResponseEntity<Integer> saveCar(@RequestBody CarRequestDto carRequestDto) {
        Integer carId = carService.saveCar(carRequestDto);
        return new ResponseEntity<>(carId, HttpStatus.OK);
    }

    @GetMapping("/findAllCars")
    public ResponseEntity<List<CarResponseDto>> findAllCars() {
        List<CarResponseDto> carResponseDtos = carService.findAllCars();
        return new ResponseEntity<>(carResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/findAllCarsByBrandId")
    public ResponseEntity<List<CarResponseDto>> findAllCarsByBrandId(@RequestParam Integer brandId) {
        List<CarResponseDto> carResponseDtos = carService.findAllCarsByBrandId(brandId);
        return new ResponseEntity<>(carResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/findAllCarsByFuelTypeId")
    public ResponseEntity<List<CarResponseDto>> findAllCarsByFuelTypeId(@RequestParam Integer fuelTypeId) {
        List<CarResponseDto> carResponseDtos = carService.findAllCarsByFuelTypeId(fuelTypeId);
        return new ResponseEntity<>(carResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCarById")
    public ResponseEntity<Boolean> deleteCarById(@RequestParam Integer carId) {
        boolean delete = carService.deleteCarById(carId);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
