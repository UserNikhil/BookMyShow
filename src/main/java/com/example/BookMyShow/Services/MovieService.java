package com.example.BookMyShow.Services;

import com.example.BookMyShow.DTOs.RequestDto.MovieDto;
import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.Repositories.MovieRepository;
import com.example.BookMyShow.Transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public String addMovie(MovieDto movieDto) {
        Movie movie= MovieTransformer.movieDtoToEntity(movieDto);
        movieRepository.save(movie);
        return "Movie is added successfully";
    }
}