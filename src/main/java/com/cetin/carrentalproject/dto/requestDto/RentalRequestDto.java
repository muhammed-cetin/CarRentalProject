package com.cetin.carrentalproject.dto.requestDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RentalRequestDto {
    private int id;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private int rentedKilometer;
    private int returnedKilometer;
    private int customerId;
    private int carId;
    private int brandId;
    private int invoiceId;
}
