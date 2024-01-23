package com.cetin.carrentalproject.dto.responseDtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IndividualCustomerResponseDto {
    private int id;
    private String email;
    private String password;
    private String nationalId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
