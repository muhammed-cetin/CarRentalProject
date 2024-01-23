package com.cetin.carrentalproject.mapper;

import com.cetin.carrentalproject.dto.CarDto;
import com.cetin.carrentalproject.model.Car;
import org.springframework.stereotype.Service;

@Service
public class CarDtoMapper {

    public static Car mapToCar(CarDto carDto) {

        return Car.builder()
                .registrationNr(carDto.getRegistrationNr())
                .brand(carDto.getBrand())
                .model(carDto.getModel())
                .isAvailable(carDto.getIsAvailable())
                .build();

    }
}
