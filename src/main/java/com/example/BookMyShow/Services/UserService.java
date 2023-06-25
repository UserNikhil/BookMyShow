package com.example.BookMyShow.Services;

import com.example.BookMyShow.DTOs.RequestDto.UserDto;
import com.example.BookMyShow.Exceptions.UserNotFound;
import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Repositories.UserRepository;
import com.example.BookMyShow.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String addUser(UserDto userDto) {
        User user= UserTransformer.UserDtoToEntity(userDto);
        userRepository.save(user);
        return "User has been added Successfully:";
    }

    public UserDto getOldestUser() throws UserNotFound {
        List<User> userList=userRepository.findAll();
        int max=0;
        User oldestUser=null;
        for (User user:userList){
            if (max<user.getAge()){
                max=user.getAge();
                oldestUser=user;
            }
        }
        if (oldestUser==null){
            throw new UserNotFound("There is no users in Our DataBase ");
        }

        UserDto userDto=UserTransformer.UserEntityToDto(oldestUser);
        return userDto;
    }

    public List<UserDto> userGreaterThanAge(Integer age) {
        List<User> userList=userRepository.userGreaterThanAge(age);

        List<UserDto> userDtos=new ArrayList<>();
        for (User user:userList){
            userDtos.add(UserTransformer.UserEntityToDto(user));
        }
        return userDtos;
    }
}