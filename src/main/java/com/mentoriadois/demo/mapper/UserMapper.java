package com.mentoriadois.demo.mapper;

import com.mentoriadois.demo.Dto.UserDto;
import com.mentoriadois.demo.model.UserModel;

public class UserMapper {
    public  static UserDto userToUserDto(UserModel user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setNome(user.getNome());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
    public static UserModel toEntity(UserDto userDto) {
        UserModel user = new UserModel();
        user.setId(userDto.getId());
        user.setNome(userDto.getNome());
        user.setEmail(userDto.getEmail());
        //Senha não vem no DTO, por isso nao precisa ser mapeada
        return user;
    }
}
