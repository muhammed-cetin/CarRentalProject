package com.cetin.carrentalproject.service.abstracts;

import com.cetin.carrentalproject.dto.requestDto.RentalRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.RentalResponseDto;

import java.util.List;

public interface RentalService {
    Integer saveRental(RentalRequestDto rentalRequestDto);

    List<RentalResponseDto> findAllRentals();

    List<RentalResponseDto> findAllRentalsById(Integer carId);

    boolean deleteRentalById(Integer rentalId);
}
