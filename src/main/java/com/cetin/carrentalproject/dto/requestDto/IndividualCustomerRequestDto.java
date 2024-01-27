package com.cetin.carrentalproject.dto.requestDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IndividualCustomerRequestDto {
    private Integer id;
    private String nationalId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
