package com.cetin.carrentalproject.service.abstracts;

import com.cetin.carrentalproject.dto.requestDto.CarDamageRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.CarDamageResponseDto;

import java.util.List;

public interface CarDamageService {
    Integer saveCarDamage(CarDamageRequestDto carDamageRequestDto);

    List<CarDamageResponseDto> findAllCarDamages();

    List<CarDamageResponseDto> findAllCarDamagesById(Integer carId);

    boolean deleteCarDamageById(Integer carDamageId);
}
