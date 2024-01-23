package com.cetin.carrentalproject.service.abstracts;

import com.cetin.carrentalproject.dto.requestDto.CarRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.CarResponseDto;

import java.util.List;

public interface CarService {
    Integer saveCar(CarRequestDto carRequestDto);

    List<CarResponseDto> findAllCars();

    List<CarResponseDto> findAllCarsByBrandId(Integer brandId);

    List<CarResponseDto> findAllCarsByFuelTypeId(Integer fuelTypeId);

    boolean deleteCarById(Integer carId);
}
