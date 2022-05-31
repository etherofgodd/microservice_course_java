package com.etherofgodd.flightcheckin.integration;

import com.etherofgodd.flightcheckin.integration.dto.Reservation;

public interface ReservationRestClient {

    public Reservation findReservation(Long id);


}
