package com.cetin.carrentalproject.mapper;

import com.cetin.carrentalproject.dto.UserDto;
import com.cetin.carrentalproject.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDtoMapper {
    public static List<UserDto> mapUserToUserDto(List<User> users) {
        return users.stream()
                .map(user -> new UserDto(user.getId(), user.getFirstName(),
                        user.getLastName(), user.getUsername(), user.getPassword(),
                        user.getEmail(), user.getPhone())).collect(Collectors.toList());
    }

}
