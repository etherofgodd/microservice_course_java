package com.etherofgodd.flight_reservation.repository;

import com.etherofgodd.flight_reservation.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPassenger extends JpaRepository<Passenger, Long> {
}
