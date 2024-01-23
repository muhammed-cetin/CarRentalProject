package com.cetin.carrentalproject.service.concretes;

import com.cetin.carrentalproject.dto.requestDto.CarDamageRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.CarDamageResponseDto;
import com.cetin.carrentalproject.model.Car;
import com.cetin.carrentalproject.model.CarDamage;
import com.cetin.carrentalproject.repository.CarDamageRepository;
import com.cetin.carrentalproject.repository.CarRepository;
import com.cetin.carrentalproject.service.abstracts.CarDamageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarDamageManager implements CarDamageService {

    @Autowired
    private CarDamageRepository carDamageRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Integer saveCarDamage(CarDamageRequestDto carDamageRequestDto) {
        CarDamage carDamage = modelMapper.map(carDamageRequestDto, CarDamage.class);
        carDamage = carDamageRepository.save(carDamage);
        return carDamage.getId();
    }

    @Override
    public List<CarDamageResponseDto> findAllCarDamages() {
        Iterable<CarDamage> carDamageList = carDamageRepository.findAll();

        List<CarDamageResponseDto> carDamageResponseDtos = new ArrayList<>();
        for (CarDamage carDamage : carDamageList) {
            CarDamageResponseDto carDamageResponseDto = modelMapper.map(carDamage, CarDamageResponseDto.class);
            carDamageResponseDtos.add(carDamageResponseDto);
        }
        return carDamageResponseDtos;
    }

    @Override
    public List<CarDamageResponseDto> findAllCarDamagesById(Integer carId) {
        Car car = carRepository.findById(carId).get();
        List<CarDamage> carDamageList = carDamageRepository.findAllCarDamagesById(car);

        List<CarDamageResponseDto> carDamageResponseDtos = new ArrayList<>();
        for (CarDamage carDamage : carDamageList) {
            CarDamageResponseDto carDamageResponseDto = modelMapper.map(carDamage, CarDamageResponseDto.class);
            carDamageResponseDtos.add(carDamageResponseDto);
        }
        return carDamageResponseDtos;
    }

    @Override
    public boolean deleteCarDamageById(Integer carDamageId) {
        CarDamage cardamage = carDamageRepository.findById(carDamageId).get();
        carDamageRepository.delete(cardamage);
        return true;
    }

}
