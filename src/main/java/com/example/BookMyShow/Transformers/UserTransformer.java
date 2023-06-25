package com.example.BookMyShow.Transformers;


import com.example.BookMyShow.DTOs.RequestDto.UserDto;
import com.example.BookMyShow.Models.User;

public class UserTransformer {

    public static User UserDtoToEntity(UserDto userDto){
        User user=User.builder().age(userDto.getAge())
                .emailId(userDto.getEmailId()).mobileNo(userDto.getMobileNo())
                .name(userDto.getName()).build();

        return user;

    }

    public static UserDto UserEntityToDto(User user){
        UserDto userDto=UserDto.builder().age(user.getAge()).name(user.getName())
                .emailId(user.getEmailId()).mobileNo(user.getMobileNo()).build();

        return userDto;
    }
}