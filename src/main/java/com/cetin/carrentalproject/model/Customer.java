package com.cetin.carrentalproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "customers")
public class Customer extends User {

    @Override
    public String getRole() {
        String getRole = "customer";
        return getRole;
    }

    @OneToMany(mappedBy = "customer")
    private List<Rental> rentals;

}
