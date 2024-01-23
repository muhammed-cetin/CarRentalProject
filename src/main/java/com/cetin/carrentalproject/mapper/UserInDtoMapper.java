package com.cetin.carrentalproject.mapper;

import com.cetin.carrentalproject.dto.UserInDto;
import com.cetin.carrentalproject.model.CreditCard;
import com.cetin.carrentalproject.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserInDtoMapper {

    public static final CreditCard CREDIT_CARD = null;

    public static User mapToUser(UserInDto userInDto) {

        return User.builder()
                .firstName(userInDto.getFirstName())
                .lastName(userInDto.getLastName())
                .username(userInDto.getUsername())
                .password(userInDto.getPassword())
                .email(userInDto.getEmail())
                .phone(userInDto.getPhone())
                .creditCard(CREDIT_CARD)
                .roles(new ArrayList<>())
                .build();

    }
}
