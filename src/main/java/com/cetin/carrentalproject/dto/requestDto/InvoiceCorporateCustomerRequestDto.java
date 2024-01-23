package com.cetin.carrentalproject.dto.requestDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InvoiceCorporateCustomerRequestDto {
    private int id;
    private String email;
    private String companyName;
    private String taxNumber;
    private LocalDate invoiceDate;
    private int rentalId;
    private double totalPrice;
}
