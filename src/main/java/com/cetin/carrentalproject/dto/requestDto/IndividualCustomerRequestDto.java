package com.cetin.carrentalproject.dto.requestDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IndividualCustomerRequestDto {
    private int id;
    private String email;
    private String password;
    private String nationalId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
