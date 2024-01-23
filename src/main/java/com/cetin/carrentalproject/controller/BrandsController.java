package com.cetin.carrentalproject.controller;


import com.cetin.carrentalproject.dto.requestDto.BrandRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.BrandResponseDto;
import com.cetin.carrentalproject.service.abstracts.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandsController {

    private BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {
        super();
        this.brandService = brandService;
    }

    @PostMapping("/saveBrand")
    public ResponseEntity<Integer> saveBrand(@RequestBody BrandRequestDto brandRequestDto) {
        Integer brandId = brandService.saveBrand(brandRequestDto);
        return new ResponseEntity<>(brandId, HttpStatus.OK);
    }

    @GetMapping("/findAllBrands")
    public ResponseEntity<List<BrandResponseDto>> findAllBrands() {
        List<BrandResponseDto> brandResponseDtos = brandService.findAllBrands();
        return new ResponseEntity<>(brandResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/findAllBrandsById")
    public ResponseEntity<List<BrandResponseDto>> findAllBrandsById(@RequestParam Integer carId) {
        List<BrandResponseDto> brandResponseDtos = brandService.findAllBrandsById(carId);
        return new ResponseEntity<>(brandResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBrandById")
    public ResponseEntity<Boolean> deleteBrandById(@RequestParam Integer brandId) {
        boolean delete = brandService.deleteBrandById(brandId);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

}

