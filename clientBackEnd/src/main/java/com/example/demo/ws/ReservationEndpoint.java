package com.example.demo.ws;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.Agent;
import com.example.demo.model.Reservation;
import com.example.demo.repository.AccommodationPhotoRepository;
import com.example.demo.repository.AccommodationPricingRepository;
import com.example.demo.repository.AccommodationRepository;
import com.example.demo.repository.AgentRepository;
import com.example.demo.service.ReservationService;
import com.example.demo.service.impl.AccommodationOptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rs.ac.uns.ftn.agenti.BookIntervalRequest;
import rs.ac.uns.ftn.agenti.BookIntervalResponse;
import rs.ac.uns.ftn.agenti.ReservationWs;
import rs.ac.uns.ftn.agenti.SendReservations;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Endpoint
public class ReservationEndpoint {
    @Autowired
    AccommodationOptionServiceImpl accommodationOptionService;
    @Autowired
    AccommodationRepository accommodationRepository;
    @Autowired
    AgentRepository agentRepository;
    @Autowired
    AccommodationPhotoRepository accommodationPhotoRepository;
    @Autowired
    AccommodationPricingRepository accommodationPricingRepository;
    @Autowired
    ReservationService reservationService;

    @PayloadRoot(namespace = AgentEndpoint.NAMESPACE_URI, localPart = "bookIntervalRequest")
    @ResponsePayload
    public BookIntervalResponse reserve(@RequestPayload BookIntervalRequest request){
        BookIntervalResponse response = new BookIntervalResponse();
        AccommodationUnit accommodationUnit = accommodationRepository.getById(request.getAccommodationId());
//        Date startDate = reservationService.toDate(request.getStartDate().toGregorianCalendar().getTime().toString().split("+")[0]);
        Date startDate = request.getStartDate().toGregorianCalendar().getTime();
        Date endDate = request.getEndDate().toGregorianCalendar().getTime();

        Reservation reservation = new Reservation(null, accommodationUnit,startDate,endDate,false);
        boolean rez = reservationService.check(reservation);
        if (rez)
            reservationService.save(reservation);
        response.setSuccess(rez);
        List<Reservation> reservations = reservationService.getByAccommodationUnit(accommodationUnit);

        for (Reservation r: reservations){
            ReservationWs reservationWs = new ReservationWs();
            reservationWs.setConfirmed(r.isConfirmed());
            reservationWs.setId(r.getId());
            reservationWs.setAccommodationId(accommodationUnit.getId());
            GregorianCalendar gc =  new GregorianCalendar();
            GregorianCalendar gc1 =  new GregorianCalendar();
            XMLGregorianCalendar xmlCalendar = null;
            XMLGregorianCalendar xmlCalendar1 = null;
            try {
                gc.setTime(r.getStartDate());
                xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
                reservationWs.setStartDate(xmlCalendar);
                gc1.setTime(r.getEndDate());
                xmlCalendar1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc1);
                reservationWs.setEndDate(xmlCalendar1);
                response.getReservations().add(reservationWs);
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    @PayloadRoot(namespace = AgentEndpoint.NAMESPACE_URI, localPart = "sendReservations")
    @ResponsePayload
    public void reserve(@RequestPayload SendReservations request){
        Reservation reservation = reservationService.getById(request.getReservations());
        if(reservation==null)
            throw new BadRequestException("Reservation was not found veki");
        reservation.setConfirmed(true);
        reservationService.save(reservation);
    }




}
