package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Models.Show;
import com.show.demo.DTOs.RequestDto.ShowDto;

public class ShowTransformer {

    public static Show showDtoToEntity(ShowDto showDto){

        Show show=Show.builder().showDate(showDto.getDate()).showTime(showDto.getTime()).build();
        return show;
    }
}