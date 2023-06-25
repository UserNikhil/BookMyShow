package com.example.BookMyShow.DTOs.RequestDto;

import com.example.BookMyShow.Enums.Genre;
import com.example.BookMyShow.Enums.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private String name;
    private double duration;
    private double rating;
    private Genre genre;
    private Language language;
    private Date reliseDate;
}