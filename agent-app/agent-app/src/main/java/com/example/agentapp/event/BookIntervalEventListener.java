package com.example.agentapp.event;

import com.example.agentapp.domain.Reservation;
import com.example.agentapp.domain.dto.BookedIntervals;
import com.example.agentapp.service.ws.impl.AccommodationUnitWSSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import schema.wsdl.BookIntervalResponse;

import javax.xml.datatype.DatatypeConfigurationException;

public class BookIntervalEventListener implements ApplicationListener<OnBookIntervalEvent> {

    @Autowired
    AccommodationUnitWSSend wsSend;

    @Override
    public void onApplicationEvent(OnBookIntervalEvent onBookIntervalEvent) {
        Reservation reservation = onBookIntervalEvent.getReservation();

        try {
            BookedIntervals response = wsSend.bookInterval(reservation);
//            response.
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
    }
}
