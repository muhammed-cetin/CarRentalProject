package com.cetin.carrentalproject.dto.responseDtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InvoiceResponseDto {
    private int id;
    private String email;
    private LocalDate invoiceDate;
    private int rentalId;
    private double totalPrice;
}
