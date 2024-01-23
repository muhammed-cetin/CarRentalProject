package com.cetin.carrentalproject.dto.responseDtos;

import lombok.Data;

@Data
public class CarDamageResponseDto {
    private int id;
    private String description;
    private int carId;
}
