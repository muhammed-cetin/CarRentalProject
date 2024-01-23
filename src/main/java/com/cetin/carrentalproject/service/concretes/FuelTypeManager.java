package com.cetin.carrentalproject.service.concretes;

import com.cetin.carrentalproject.dto.requestDto.FuelTypeRequestDto;
import com.cetin.carrentalproject.model.FuelType;
import com.cetin.carrentalproject.repository.FuelTypeRepository;
import com.cetin.carrentalproject.service.abstracts.FuelTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuelTypeManager implements FuelTypeService {

    @Autowired
    private FuelTypeRepository fuelTypeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Integer saveFuelType(FuelTypeRequestDto fuelTypeRequestDto) {
        FuelType fuelType = modelMapper.map(fuelTypeRequestDto, FuelType.class);
        fuelType = fuelTypeRepository.save(fuelType);
        return fuelType.getId();
    }
}
