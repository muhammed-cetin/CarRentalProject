package com.cetin.carrentalproject.mapper;

import com.cetin.carrentalproject.dto.CarPackageDto;
import com.cetin.carrentalproject.model.CarPackage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarPackageDtoMapper {

    public static CarPackage mapToCarPackage(CarPackageDto carPackageDto) {

        return CarPackage.builder()
                .packageName(carPackageDto.getPackageName())
                .pricePerHour(carPackageDto.getPricePerHour())
                .cars(new ArrayList<>())
                .build();

    }
}
