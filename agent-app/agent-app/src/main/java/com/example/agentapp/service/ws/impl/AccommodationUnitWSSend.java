package com.example.agentapp.service.ws.impl;

import com.example.agentapp.domain.AccommodationPricing;
import com.example.agentapp.domain.AccommodationUnit;
import com.example.agentapp.domain.Reservation;
import com.example.agentapp.domain.dto.BookedIntervals;
import com.example.agentapp.service.AccommodationUnitService;
import com.example.agentapp.service.BookedIntervalService;
import com.example.agentapp.ws.WSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schema.wsdl.BookIntervalResponse;
import schema.wsdl.CreateAccommodationResponse;
import schema.wsdl.ReservationWs;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccommodationUnitWSSend {

    @Autowired
    private WSClient wsClient;

    @Autowired
    private AccommodationUnitService accommodationUnitService;

    @Autowired
    private BookedIntervalService bookedIntervalService;

    public CreateAccommodationResponse createAccommodationUnit(AccommodationUnit unit, AccommodationPricing pricing,
                                                        List<String> encodedImages) {

        CreateAccommodationResponse response = wsClient.createAccommodation(unit, pricing, encodedImages);
        return response;
    }

    public BookedIntervals bookInterval(Reservation reservation) throws DatatypeConfigurationException {

        BookIntervalResponse response = wsClient.bookInterval(reservation);

        List<Reservation> reservations = response.getReservations()
                .stream()
                .map(el -> new Reservation(el.getId(), el.getStartDate().toGregorianCalendar().getTime(),
                        el.getEndDate().toGregorianCalendar().getTime(), reservation.getAccommodationUnit()))
                .collect(Collectors.toList());

        return new BookedIntervals(reservations, response.isSuccess());
    }

    public void confirmReservation(long id) {
        wsClient.confirmReservation(id);
    }


}
