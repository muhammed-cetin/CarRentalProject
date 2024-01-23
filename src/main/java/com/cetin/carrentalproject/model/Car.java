package com.cetin.carrentalproject.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "kilometer")
    private int kilometer;

    @Column(name = "description")
    private String description;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

    @ManyToOne
    @JoinColumn(name = "fuelType_id")
    private FuelType fuelType;

    @OneToMany(mappedBy = "car")
    private List<CarDamage> carDamages;
}
