package com.cetin.carrentalproject.dto.responseDtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IndividualCustomerResponseDto {
    private String nationalId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
