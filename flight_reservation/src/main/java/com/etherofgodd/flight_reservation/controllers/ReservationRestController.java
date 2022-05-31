package com.etherofgodd.flight_reservation.controllers;


import com.etherofgodd.flight_reservation.dto.ReservationUpdateRequest;
import com.etherofgodd.flight_reservation.entities.Reservation;
import com.etherofgodd.flight_reservation.repository.IReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ReservationRestController {

    private final IReservationRepository reservationRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

    @Autowired
    public ReservationRestController(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id) {
        LOGGER.info("Inside ");
        return reservationRepository.findById(id).get();
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest reservationUpdateRequest) {
        Reservation reservation = reservationRepository
                .findById(reservationUpdateRequest.getId()).get();
        reservation.setNumberOfBags(reservationUpdateRequest.getNumberOfBags());
        reservation.setCheckedIn(reservationUpdateRequest.getCheckedIn());

        return reservationRepository.save(reservation);
    }
}
