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
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "payment_date")
    private LocalDate paymetDate;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Rental rental;
}

