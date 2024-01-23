package com.cetin.carrentalproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "invoice_date")
    private LocalDate invoiceDate;

    @OneToOne
    @JoinColumn(name = "rental_id", unique = true)
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "corporate_customer_id")
    private CorporateCustomer corporateCustomer;

    @ManyToOne
    @JoinColumn(name = "individual_customer_id")
    private IndividualCustomer individualCustomer;

}
