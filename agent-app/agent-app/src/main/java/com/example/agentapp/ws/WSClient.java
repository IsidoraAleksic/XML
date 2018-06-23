package com.example.agentapp.ws;

import com.example.agentapp.domain.*;
import com.example.agentapp.mapper.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import schema.wsdl.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.List;


public class WSClient extends WebServiceGatewaySupport {

    @Value("${producer.default-uri}")
    private String PRODUCER_URI;

    private ObjectFactory objectFactory = new ObjectFactory();

    public LoginAgentResponse loginAgent(String email, String password) {
        LoginAgentRequest request = new LoginAgentRequest();
        request.setEmail(email);
        request.setPassword(password);

        LoginAgentResponse response = (LoginAgentResponse) getWebServiceTemplate()
                .marshalSendAndReceive(PRODUCER_URI, request,
                        new SoapActionCallback(PRODUCER_URI+"/loginAgentRequest"));
        return response;
    }

    public GetAccommodationParametersResponse getAccommodationParameters() {
        GetAccommodationParametersRequest request = new GetAccommodationParametersRequest();
        request.setStaos("daj parametre pls");
        GetAccommodationParametersResponse response = (GetAccommodationParametersResponse)getWebServiceTemplate()
                .marshalSendAndReceive(PRODUCER_URI, request,
                        new SoapActionCallback(PRODUCER_URI+"/getAccommodationParametersRequest"));
        return response;
    }

    public GetAccommodationByAgentIdResponse getAccommodationByAgentId(long id) {
        GetAccommodationByAgentIdReguest reguest = new GetAccommodationByAgentIdReguest();
        reguest.setId(id);
        GetAccommodationByAgentIdResponse response = (GetAccommodationByAgentIdResponse)getWebServiceTemplate()
                .marshalSendAndReceive(PRODUCER_URI, reguest,
                        new SoapActionCallback(PRODUCER_URI+"/getAccommodationByAgentIdReguest"));
        return response;
    }

    public CreateAccommodationResponse createAccommodation(AccommodationUnit unit, AccommodationPricing pricing,
                                                           List<String> encodedImages) {
        CreateAccommodationRequest request = new CreateAccommodationRequest();

        AccommodationUnitWs accommodationUnitWs = AccommodationUnitConverter.fromPojoToXMLType(unit);
        Pricing pricingWs = PricingConverter.fromPojoToXMLType(pricing);

        request.setAccommodationUnit(accommodationUnitWs);
        request.setPricing(pricingWs);
        request.getImageSrc().addAll(encodedImages);

        CreateAccommodationResponse response = (CreateAccommodationResponse) getWebServiceTemplate()
                .marshalSendAndReceive(PRODUCER_URI, request,
                        new SoapActionCallback(PRODUCER_URI+"/createAccommodationRequest"));
        return response;
    }

    public BookIntervalResponse bookInterval(Reservation reservation) throws DatatypeConfigurationException {
        BookIntervalRequest request = new BookIntervalRequest();

        GregorianCalendar fromGreg = new GregorianCalendar();
        fromGreg.setTime(reservation.getFromDate());
        XMLGregorianCalendar fromXMLDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(fromGreg);

        GregorianCalendar toGreg = new GregorianCalendar();
        toGreg.setTime(reservation.getToDate());
        XMLGregorianCalendar toXMLDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(toGreg);

        request.setAccommodationId(reservation.getAccommodationUnit().getId());
        request.setStartDate(fromXMLDate);
        request.setEndDate(toXMLDate);

        BookIntervalResponse response = (BookIntervalResponse) getWebServiceTemplate()
                .marshalSendAndReceive(PRODUCER_URI, request,
                        new SoapActionCallback(PRODUCER_URI+"/bookIntervalRequest"));
        return response;
    }

    public MessagesResponse sendMessage(Message message) {
        SendMessageRequest request = new SendMessageRequest();
        MessageWs messageWs = objectFactory.createMessageWs();
        messageWs.setAgent(true);
        messageWs.setMessage(message.getMessage());
        messageWs.setReservationId(message.getReservation().getId());
        request.setMessage(messageWs);

        MessagesResponse response = (MessagesResponse) getWebServiceTemplate()
                .marshalSendAndReceive(PRODUCER_URI, request,
                        new SoapActionCallback(PRODUCER_URI+"/sendMessageRequest"));

        return response;
    }
}
