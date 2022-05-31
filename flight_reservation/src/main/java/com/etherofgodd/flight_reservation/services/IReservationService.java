package com.etherofgodd.flight_reservation.services;

import com.etherofgodd.flight_reservation.dto.ReservationRequest;
import com.etherofgodd.flight_reservation.entities.Reservation;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public interface IReservationService {
    public Reservation bookFlight(ReservationRequest request);
}
