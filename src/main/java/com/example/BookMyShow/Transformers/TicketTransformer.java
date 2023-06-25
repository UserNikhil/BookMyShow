package com.example.BookMyShow.Transformers;


import com.example.BookMyShow.DTOs.RsponceDto.TicketResDto;
import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.Models.Ticket;

public class TicketTransformer {

    public static TicketResDto getTicketResDto(Show show, Ticket ticket){
        TicketResDto ticketResDto=new TicketResDto();
        ticketResDto.setDate(show.getShowDate());
        ticketResDto.setMovieName(show.getMovie().getName());
        ticketResDto.setTheaterName(show.getTheater().getName());
        ticketResDto.setBookedSeat(ticket.getBookedSeats());
        ticketResDto.setShowTime(show.getShowTime());
        return ticketResDto;
    }
}