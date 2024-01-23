package com.cetin.carrentalproject.dto.requestDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InvoiceIndividualCustomerRequestDto {
    private int id;
    private String email;
    private String nationalId;
    private String firstName;
    private String lastName;
    private LocalDate invoiceDate;
    private int rentalId;
    private double totalPrice;
}
