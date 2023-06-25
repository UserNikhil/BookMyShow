package com.example.BookMyShow.Repositories;


import com.example.BookMyShow.Models.Theaterseat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatRepository extends JpaRepository<Theaterseat,Integer> {
}