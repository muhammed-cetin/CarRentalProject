package com.cetin.carrentalproject.service.concretes;

import com.cetin.carrentalproject.dto.requestDto.CarRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.CarResponseDto;
import com.cetin.carrentalproject.model.Brand;
import com.cetin.carrentalproject.model.Car;
import com.cetin.carrentalproject.model.FuelType;
import com.cetin.carrentalproject.repository.BrandRepository;
import com.cetin.carrentalproject.repository.CarRepository;
import com.cetin.carrentalproject.repository.FuelTypeRepository;
import com.cetin.carrentalproject.service.abstracts.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarManager implements CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private FuelTypeRepository fuelTypeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Integer saveCar(CarRequestDto carRequestDto) {
        Car car = modelMapper.map(carRequestDto, Car.class);
        car = carRepository.save(car);
        return car.getId();
    }

    @Override
    public List<CarResponseDto> findAllCars() {
        Iterable<Car> carList = carRepository.findAll();

        List<CarResponseDto> carResponseDtos = new ArrayList<>();
        for (Car car : carList) {
            CarResponseDto carResponseDto = modelMapper.map(car, CarResponseDto.class);
            carResponseDtos.add(carResponseDto);
        }

        return carResponseDtos;
    }

    @Override
    public List<CarResponseDto> findAllCarsByBrandId(Integer brandId) {
        Brand brand = brandRepository.findById(brandId).get();
        List<Car> carList = carRepository.findAllCarsByBrandId(brand);

        List<CarResponseDto> carResponseDtos = new ArrayList<>();
        for (Car car : carList) {
            CarResponseDto carResponseDto = modelMapper.map(car, CarResponseDto.class);
            carResponseDtos.add(carResponseDto);
        }
        return carResponseDtos;
    }

    @Override
    public List<CarResponseDto> findAllCarsByFuelTypeId(Integer fuelTypeId) {
        FuelType fuelType = fuelTypeRepository.findById(fuelTypeId).get();
        List<Car> carList = carRepository.findAllCarsByFuelTypeId(fuelType);

        List<CarResponseDto> carResponseDtos = new ArrayList<>();
        for (Car car : carList) {
            CarResponseDto carResponseDto = modelMapper.map(car, CarResponseDto.class);
            carResponseDtos.add(carResponseDto);
        }
        return carResponseDtos;
    }

    @Override
    public boolean deleteCarById(Integer carId) {
        Car car = carRepository.findById(carId).get();
        carRepository.delete(car);
        return true;
    }

}
