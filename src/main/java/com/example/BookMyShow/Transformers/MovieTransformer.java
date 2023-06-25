package com.example.BookMyShow.Transformers;


import com.example.BookMyShow.DTOs.RequestDto.MovieDto;
import com.example.BookMyShow.Models.Movie;

public class MovieTransformer {

    public static Movie movieDtoToEntity(MovieDto movieDto){
        Movie movie=Movie.builder().name(movieDto.getName())
                .genre(movieDto.getGenre()).duration(movieDto.getDuration())
                .rating(movieDto.getRating()).language(movieDto.getLanguage())
                .reliseDate(movieDto.getReliseDate())
                .build();

        return movie;
    }
}