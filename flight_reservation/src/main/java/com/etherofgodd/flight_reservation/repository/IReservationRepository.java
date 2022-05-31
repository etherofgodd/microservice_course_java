package com.etherofgodd.flight_reservation.repository;

import com.etherofgodd.flight_reservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservation extends JpaRepository<Reservation, Long> {
}
