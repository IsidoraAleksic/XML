package com.example.agentapp.service.ws.impl;

import com.example.agentapp.domain.*;
import com.example.agentapp.service.AccommodationAttributeService;
import com.example.agentapp.service.AccommodationUnitService;
import com.example.agentapp.service.BookedIntervalService;
import com.example.agentapp.service.MessageService;
import com.example.agentapp.ws.WSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schema.wsdl.GetAccommodationByAgentIdResponse;
import schema.wsdl.GetAccommodationParametersResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccommodationUnitWSGet {

    @Autowired
    private WSClient wsClient;

    @Autowired
    private AccommodationAttributeService accommodationAttributeService;

    @Autowired
    private AccommodationUnitService accommodationUnitService;

    @Autowired
    private BookedIntervalService bookedIntervalService;

    @Autowired
    private MessageService messageService;


    public void getAccommodationParameters() {
        GetAccommodationParametersResponse response = wsClient.getAccommodationParameters();
        List<AccommodationCategory> categories = response.getAccommodationCategories()
                .stream()
                .map(cat -> new AccommodationCategory(cat.getId(), cat.getCategoryName()))
                .collect(Collectors.toList());
        List<AccommodationType> types = response.getAccommodationTypes()
                .stream()
                .map(type -> new AccommodationType(type.getId(), type.getTypeName()))
                .collect(Collectors.toList());
        List<AdditionalService> services = response.getAdditionalServices()
                .stream()
                .map(srvc -> new AdditionalService(srvc.getId(), srvc.getName()))
                .collect(Collectors.toList());

        accommodationAttributeService.insertAccommodationCategories(categories);
        accommodationAttributeService.insertAccommodationTypes(types);
        accommodationAttributeService.insertAdditionalServices(services);
    }

    public void getAllAccommodationUnits(long agentId) {
        GetAccommodationByAgentIdResponse response = wsClient.getAccommodationByAgentId(agentId);
        List<AccommodationUnit> units = getUnits(response);
        accommodationUnitService.saveUnits(units);

        List<Reservation> reservations = getReservations(response);
        bookedIntervalService.saveReservations(reservations);

        List<Message> messages = getMessages(response);
        messageService.saveMessages(messages);
    }

    private List<Reservation> getReservations(GetAccommodationByAgentIdResponse response) {
        return response.getReservations()
                .stream()
                .map(res -> {
                    AccommodationUnit accUnit = accommodationUnitService.getUnit(res.getAccommodationId());
                    return new Reservation(res.getId(), res.getStartDate().toGregorianCalendar().getTime(), res.getEndDate().toGregorianCalendar().getTime(), accUnit);
                })
                .collect(Collectors.toList());
    }

    private List<Message> getMessages(GetAccommodationByAgentIdResponse response) {
        return response.getMessages()
                .stream()
                .map(msg -> {
                    Reservation reservation = bookedIntervalService.getById(msg.getReservationId());
                    return new Message(msg.getId(), reservation, msg.getMessage(), msg.isAgent());
                })
                .collect(Collectors.toList());
    }


    private List<AccommodationUnit> getUnits(GetAccommodationByAgentIdResponse response) {
        return response.getAccommodationUnitWs()
                .stream()
                .map(unitWs -> {
                    AccommodationUnit unit = new AccommodationUnit();
                    unit.setId(unitWs.getId());
                    unit.setCapacity(unitWs.getCapacity());
                    unit.setDescription(unitWs.getDescription());
                    unit.setPlace(unitWs.getPlace());
                    unit.setAccommodationType(new AccommodationType(unitWs.getAccommodationType().getId(), unitWs.getAccommodationType().getTypeName()));
                    unit.setCategory(new AccommodationCategory(unitWs.getCategory().getId(), unitWs.getCategory().getCategoryName()));
                    unit.setAdditionalServices(unitWs.getAdditionalServices()
                            .stream()
                            .map(srvc -> new AdditionalService(srvc.getId(), srvc.getName()))
                            .collect(Collectors.toList()));
                    unit.setAgent(new Agent(unitWs.getAgent().getId(), unitWs.getAgent().getEmail(), unitWs.getAgent().getPassword(),
                            unitWs.getAgent().getName(), unitWs.getAgent().getSurname(), unitWs.getAgent().getRegNumber()));
                    return unit;
                })
                .collect(Collectors.toList());
    }


}
