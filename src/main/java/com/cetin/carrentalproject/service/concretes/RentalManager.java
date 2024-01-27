package com.cetin.carrentalproject.service.concretes;

import com.cetin.carrentalproject.dto.requestDto.RentalRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.RentalResponseDto;
import com.cetin.carrentalproject.model.Car;
import com.cetin.carrentalproject.model.Rental;
import com.cetin.carrentalproject.repository.CarRepository;
import com.cetin.carrentalproject.repository.RentalRepository;
import com.cetin.carrentalproject.service.abstracts.RentalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentalManager implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Integer saveRental(RentalRequestDto rentalRequestDto) {
        Rental rental = modelMapper.map(rentalRequestDto, Rental.class);
        rental = rentalRepository.save(rental);
        return rental.getId();
    }

    @Override
    public List<RentalResponseDto> findAllRentals() {
        Iterable<Rental> rentalList = rentalRepository.findAll();

        List<RentalResponseDto> rentalResponseDtos = new ArrayList<>();
        for (Rental rental : rentalList) {
            RentalResponseDto rentalResponseDto = modelMapper.map(rental, RentalResponseDto.class);
            rentalResponseDtos.add(rentalResponseDto);
        }

        return rentalResponseDtos;
    }

    @Override
    public List<RentalResponseDto> findAllRentalsById(Integer carId) {
        Car car = carRepository.findById(carId).get();
        List<Rental> rentalList = rentalRepository.findAllByCarId(car);

        List<RentalResponseDto> rentalResponseDtos = new ArrayList<>();
        for (Rental rental : rentalList) {
            RentalResponseDto rentalResponseDto = modelMapper.map(rental, RentalResponseDto.class);
            rentalResponseDtos.add(rentalResponseDto);
        }

        return rentalResponseDtos;
    }

    @Override
    public boolean deleteRentalById(Integer rentalId) {
        rentalRepository.deleteById(rentalId);
        return true;
    }

}
