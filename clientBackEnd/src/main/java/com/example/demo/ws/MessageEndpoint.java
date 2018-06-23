package com.example.demo.ws;

import com.example.demo.mapper.MessageConverter;
import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.Agent;
import com.example.demo.model.Message;
import com.example.demo.model.Reservation;
import com.example.demo.repository.AgentRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rs.ac.uns.ftn.agenti.*;

import java.util.List;

@Endpoint
public class MessageEndpoint {

    public static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/agenti";

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    MessageService messageService;
    @Autowired
    AgentRepository agentRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendMessageRequest")
    @ResponsePayload
    public MessagesResponse sendMessage(@RequestPayload SendMessageRequest request){
        MessagesResponse response = new MessagesResponse();
        MessageWs messageWs = request.getMessage();
        Reservation reservation = reservationRepository.getById(request.getMessage().getReservationId());
        Message message = MessageConverter.fromXMLTypeToPojo(messageWs);
        message.setReservation(reservation);
        messageService.send(message);
        MessageWs ws = MessageConverter.fromPojoToXMLType(message);
        ws.setReservationId(message.getReservation().getId());
        response.setMessage(ws);
        return response;
    }


//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMessagesRequest")
//    @ResponsePayload
//    public GetMessagesResponse getMessages(@RequestPayload GetMessagesRequest request){
//        GetMessagesResponse response = new GetMessagesResponse();
//        Agent agent = agentRepository.getById(request.getAgentId());
//        List<AccommodationUnit> accommodationUnits =
//        return response;
//    }


}
