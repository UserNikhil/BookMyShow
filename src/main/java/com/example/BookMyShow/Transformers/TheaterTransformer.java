package com.example.BookMyShow.Transformers;


import com.example.BookMyShow.DTOs.RequestDto.TheaterDto;
import com.example.BookMyShow.Models.Theater;

public class TheaterTransformer {

    public static Theater TheaterDtoToEntity(TheaterDto theaterDto){
        Theater theater=Theater.builder().name(theaterDto.getName())
                .location(theaterDto.getLocation()).build();
        return theater;
    }
}