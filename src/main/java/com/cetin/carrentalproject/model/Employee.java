package com.cetin.carrentalproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "employees")
public class Employee extends User {

    @Override
    public String getRole() {
        String getRole = "employee";
        return getRole;
    }
}

