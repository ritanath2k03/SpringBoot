package com.ritanath.library.mapper;

import com.ritanath.library.dto.UserDto;
import com.ritanath.library.model.AppUser;

public class UserMapper {

    public static AppUser toEntity(UserDto userDto) {
        return AppUser.builder()
            .id(userDto.getId())
            .name(userDto.getName())
            .email(userDto.getEmail())
            .phone(userDto.getPhone())
            .address(userDto.getAddress())
            .build();
    }

    public static UserDto toDto(AppUser user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(user.getAddress())
                .build();
    }


}
