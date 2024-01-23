package com.cetin.carrentalproject.service.abstracts;

import com.cetin.carrentalproject.dto.requestDto.FuelTypeRequestDto;

public interface FuelTypeService {
    Integer saveFuelType(FuelTypeRequestDto fuelTypeRequestDto);
}
