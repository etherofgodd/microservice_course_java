package com.etherofgodd.flight_reservation.services;

import com.etherofgodd.flight_reservation.controllers.ReservationController;
import com.etherofgodd.flight_reservation.dto.ReservationRequest;
import com.etherofgodd.flight_reservation.entities.Flight;
import com.etherofgodd.flight_reservation.entities.Passenger;
import com.etherofgodd.flight_reservation.entities.Reservation;
import com.etherofgodd.flight_reservation.repository.IFlightRepository;
import com.etherofgodd.flight_reservation.repository.IPassengerRepository;
import com.etherofgodd.flight_reservation.repository.IReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService implements IReservationService {


    IFlightRepository flightRepository;
    IPassengerRepository passengerRepository;

    IReservationRepository reservationRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);


    @Autowired
    ReservationService(IFlightRepository flightRepository, IPassengerRepository passenger, IReservationRepository reservationRepository) {
        this.flightRepository = flightRepository;
        this.passengerRepository = passenger;
        this.reservationRepository = reservationRepository;
    }


    @Override
    public Reservation bookFlight(ReservationRequest request) {


        Long flightId = request.getFlightId();
        Flight flight = flightRepository.findById(flightId).get();

        Passenger passenger = new Passenger();

        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());

        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        Reservation savedReservation = reservationRepository.save(reservation);

        LOGGER.info("Inside the bookFlight() with params: " + savedReservation);


        return savedReservation;
    }
}
