package com.cetin.carrentalproject.service.concretes;

import com.cetin.carrentalproject.dto.requestDto.BrandRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.BrandResponseDto;
import com.cetin.carrentalproject.model.Brand;
import com.cetin.carrentalproject.model.Car;
import com.cetin.carrentalproject.repository.BrandRepository;
import com.cetin.carrentalproject.repository.CarRepository;
import com.cetin.carrentalproject.service.abstracts.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public BrandManager(BrandRepository brandRepository, CarRepository carRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Integer saveBrand(BrandRequestDto brandRequestDto) {
        Brand brand = modelMapper.map(brandRequestDto, Brand.class);
        brand = brandRepository.save(brand);
        return brand.getId();
    }

    @Override
    public List<BrandResponseDto> findAllBrands() {
        Iterable<Brand> brandList = brandRepository.findAll();

        List<BrandResponseDto> brandResponseDtos = new ArrayList<>();
        for (Brand brand : brandList) {
            BrandResponseDto brandResponseDto = modelMapper.map(brand, BrandResponseDto.class);
            brandResponseDtos.add(brandResponseDto);
        }
        return brandResponseDtos;
    }

    @Override
    public List<BrandResponseDto> findAllBrandsById(Integer carId) {
        Car car = carRepository.findById(carId).get();
        List<Brand> brandList = brandRepository.findAllBrandsById(car);

        List<BrandResponseDto> brandResponseDtos = new ArrayList<>();
        for (Brand brand : brandList) {
            BrandResponseDto brandResponseDto = modelMapper.map(brand, BrandResponseDto.class);
            brandResponseDtos.add(brandResponseDto);
        }
        return brandResponseDtos;
    }

    @Override
    public boolean deleteBrandById(Integer brandId) {
        Brand brand = brandRepository.findById(brandId).get();
        brandRepository.delete(brand);
        return true;
    }

}

