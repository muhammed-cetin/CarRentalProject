package com.cetin.carrentalproject.service.abstracts;

import com.cetin.carrentalproject.dto.requestDto.BrandRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.BrandResponseDto;

import java.util.List;

public interface BrandService {
    Integer saveBrand(BrandRequestDto brandRequestDto);

    List<BrandResponseDto> findAllBrands();

    List<BrandResponseDto> findAllBrandsById(Integer carId);

    boolean deleteBrandById(Integer brandId);
}
