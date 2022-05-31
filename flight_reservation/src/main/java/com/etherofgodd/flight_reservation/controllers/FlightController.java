package com.etherofgodd.flight_reservation.controllers;


import com.etherofgodd.flight_reservation.entities.Flight;
import com.etherofgodd.flight_reservation.repository.IFlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {

    private final IFlightRepository flightRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);


    @Autowired
    public FlightController(IFlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @RequestMapping("/findFlights")
    public String findFlights(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("departureDate")
            @DateTimeFormat(pattern = "MM-dd-yyyy")
            Date departureDate,
            ModelMap modelMap
    ) {
        LOGGER.info("Inside the find flights page::" + from + " /" + to + "/" + departureDate);
        List<Flight> flightList = flightRepository.findFlights(from, to, departureDate);
        modelMap.addAttribute("flights", flightList);
        LOGGER.info("Flights found are: " + flightList);


        return "displayFlights";
    }

}
