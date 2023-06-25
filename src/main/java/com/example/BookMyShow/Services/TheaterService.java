package com.example.BookMyShow.Services;

import com.example.BookMyShow.DTOs.RequestDto.TheaterDto;
import com.example.BookMyShow.DTOs.RequestDto.TheaterSeatDto;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Exceptions.TheaterNotFound;
import com.example.BookMyShow.Models.Theater;
import com.example.BookMyShow.Models.Theaterseat;
import com.example.BookMyShow.Repositories.TheaterRepository;
import com.example.BookMyShow.Transformers.TheaterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;
    public String addTheater(TheaterDto theaterDto) {

        Theater theater= TheaterTransformer.TheaterDtoToEntity(theaterDto);
        theaterRepository.save(theater);

        return "Theater added Sucessfully";
    }

    public String addTheaterSeats(TheaterSeatDto theaterSeatDto) throws TheaterNotFound {
        Theater optionalTheater= theaterRepository.findByLocation(theaterSeatDto.getLocation());
        if (optionalTheater==null){
            throw new TheaterNotFound("Theare  is not any Theater on  location");
        }

        Integer col=theaterSeatDto.getNoOfSeatsIn1Row();
        Integer classicSeats= theaterSeatDto.getNofOfClassicSeats();
        Integer primiumSeats= theaterSeatDto.getNoOfPremiumSeats();

        List<Theaterseat> theaterseatList=optionalTheater.getTheaterseatList();

        int seatCount=1;
        char ch='A';

        for (int i=1; i<=classicSeats; i++){

            String seatNo=seatCount+"";
            seatNo+=ch;
            ch++;
            if(ch-'A'==col){
                ch='A';
                seatCount++;
            }
            Theaterseat seat=Theaterseat.builder().seatNo(seatNo).seatType(SeatType.CLASSIC).theater(optionalTheater).build();
            theaterseatList.add(seat);
        }

        for (int i=1; i<=primiumSeats; i++){
            String seatNo=seatCount+"";
            seatNo+=ch;
            ch++;
            if(ch-'A'==col){
                ch='A';
                seatCount++;
            }

            Theaterseat seat=Theaterseat.builder().seatNo(seatNo).seatType(SeatType.PREMIUM).theater(optionalTheater).build();
            theaterseatList.add(seat);
        }

        theaterRepository.save(optionalTheater);
        return "Theater Seat Successfully Added to the theater";
    }

}