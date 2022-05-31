package com.etherofgodd.flight_reservation.controllers;


import com.etherofgodd.flight_reservation.dto.ReservationRequest;
import com.etherofgodd.flight_reservation.entities.Flight;
import com.etherofgodd.flight_reservation.entities.Reservation;
import com.etherofgodd.flight_reservation.repository.IFlightRepository;
import com.etherofgodd.flight_reservation.services.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {


    private final IFlightRepository flightRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);


    ReservationService reservationService;


    @Autowired
    public ReservationController(IFlightRepository flightRepository,
                                 ReservationService reservationService
    ) {
        this.flightRepository = flightRepository;
        this.reservationService = reservationService;
    }

    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
        LOGGER.info("Inside showCompleteReservation + id: " + flightId);

        Flight flight = flightRepository.findById(flightId).get();
        modelMap.addAttribute("flight", flight);

        return "completeReservation";
    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String completeReservation(ReservationRequest request, ModelMap modelMap) {

        Reservation reservation = reservationService.bookFlight(request);

        LOGGER.info("Inside completeReservation + reservation: " + reservation);

        modelMap.addAttribute(
                "msg",
                "Reservation saved with the id of: "
                        + reservation.getId());
        return "reservationConfirmation";
    }

}
