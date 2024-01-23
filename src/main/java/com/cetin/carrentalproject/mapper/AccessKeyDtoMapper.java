package com.cetin.carrentalproject.mapper;

import com.cetin.carrentalproject.dto.AccessKeyDto;
import com.cetin.carrentalproject.model.AccessKey;
import org.springframework.stereotype.Service;

@Service
public class AccessKeyDtoMapper {
    public static AccessKeyDto mapToAccessKeyDto(AccessKey accessKey) {
        return AccessKeyDto.builder()
                .id(accessKey.getId())
                .carPackage(accessKey.getCarPackage())
                .hours(accessKey.getHours())
                .build();
    }
}
