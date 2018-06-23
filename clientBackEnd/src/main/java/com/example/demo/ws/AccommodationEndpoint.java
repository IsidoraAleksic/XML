package com.example.demo.ws;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.mapper.MessageConverter;
import com.example.demo.model.*;
import com.example.demo.model.dto.SearchParameters;
import com.example.demo.repository.*;
import com.example.demo.service.AccommodationService;
import com.example.demo.service.impl.AccommodationOptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rs.ac.uns.ftn.agenti.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Endpoint
public class AccommodationEndpoint {

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
    MessageRepository messageRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @PayloadRoot(namespace = AgentEndpoint.NAMESPACE_URI, localPart = "getAccommodationParametersRequest")
    @ResponsePayload
    public GetAccommodationParametersResponse getAccommodationParameters(@RequestPayload GetAccommodationParametersRequest request){
        SearchParameters parameters =  accommodationOptionService.getParameters();
        GetAccommodationParametersResponse response = new GetAccommodationParametersResponse();

        List<AdditionalServicesWs> asList = new ArrayList<>();
        for(AdditionalServices as: parameters.getAdditionalServices()){
            AdditionalServicesWs additionalServicesWs = new AdditionalServicesWs();
            additionalServicesWs.setId(as.getId());
            additionalServicesWs.setName(as.getName());
            asList.add(additionalServicesWs);
        }
        response.getAdditionalServices().addAll(asList);
        //drugi for
        List<AccommodationCategoryWs> acList = new ArrayList<>();
        for(AccommodationCategory as: parameters.getAccommodationCategories()){
            AccommodationCategoryWs accommodationCategoryWs = new AccommodationCategoryWs();
            accommodationCategoryWs.setId(as.getId());
            accommodationCategoryWs.setCategoryName(as.getCategoryName());
            acList.add(accommodationCategoryWs);
        }
        response.getAccommodationCategories().addAll(acList);

        //treci for
        List<AccommodationTypeWs> atList = new ArrayList<>();
        for(AccommodationType as: parameters.getAccommodationTypes()){
            AccommodationTypeWs accommodationTypeWs = new AccommodationTypeWs();
            accommodationTypeWs.setId(as.getId());
            accommodationTypeWs.setTypeName(as.getTypeName());
            atList.add(accommodationTypeWs);
        }
        response.getAccommodationTypes().addAll(atList);
        return response;


    }

    @PayloadRoot(namespace = AgentEndpoint.NAMESPACE_URI, localPart = "getAccommodationByAgentIdReguest")
    @ResponsePayload
    public GetAccommodationByAgentIdResponse getAccommodation(@RequestPayload GetAccommodationByAgentIdReguest request){
        List<AccommodationUnit> accommodationUnits = accommodationRepository.getByAgent_Id(request.getId());
        GetAccommodationByAgentIdResponse response = new GetAccommodationByAgentIdResponse();
//        response.getAccommodationUnitWs().addAll()
        List<AccommodationUnitWs> accommodationUnitWs = new ArrayList<>();
        for(AccommodationUnit au : accommodationUnits) {
            AccommodationUnitWs aw = new AccommodationUnitWs();
            aw.setId(au.getId());
            aw.setCapacity(au.getCapacity());
            aw.setDescription(au.getDescription());
            aw.setPlace(au.getPlace());

            AgentWs agentWs = new AgentWs();
            agentWs.setId(au.getAgent().getId());
            agentWs.setEmail(au.getAgent().getEmail());
            agentWs.setName(au.getAgent().getName());
            agentWs.setSurname(au.getAgent().getSurname());
            agentWs.setPassword(au.getAgent().getPassword());
            agentWs.setRegNumber(au.getAgent().getRegNumber());
            aw.setAgent(agentWs);

            AccommodationTypeWs at = new AccommodationTypeWs();
            at.setId(au.getAccommodationType().getId());
            at.setTypeName(au.getAccommodationType().getTypeName());
            aw.setAccommodationType(at);

            AccommodationCategoryWs ac = new AccommodationCategoryWs();
            ac.setId(au.getCategory().getId());
            ac.setCategoryName(au.getCategory().getCategoryName());
            aw.setCategory(ac);

            List<AdditionalServicesWs> asList = new ArrayList<>();
            for(AdditionalServices additionalServices: au.getAdditionalServices()){
                AdditionalServicesWs as = new AdditionalServicesWs();
                as.setId(additionalServices.getId());
                as.setName(additionalServices.getName());
                asList.add(as);
            }
            aw.getAdditionalServices().addAll(asList);
            accommodationUnitWs.add(aw);

            List<Reservation> reservations = reservationRepository.getByAccommodationUnit(au);
            //TODO: CHECK IF ADDING ALL
            for(Reservation reservation: reservations){
                ReservationWs reservationWs = new ReservationWs();
                reservationWs.setId(reservation.getId());
                reservationWs.setAccommodationId(au.getId());
                GregorianCalendar gc =  new GregorianCalendar();
                XMLGregorianCalendar xmlCalendar = null;
                try {
                    gc.setTime(reservation.getEndDate());
                    xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
                    reservationWs.setEndDate(xmlCalendar);
                    gc.setTime(reservation.getStartDate());
                    xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
                    reservationWs.setStartDate(xmlCalendar);
                    response.getReservations().add(reservationWs);
                } catch (DatatypeConfigurationException e) {
                    e.printStackTrace();
                }
                List<Message> messages = messageRepository.getByReservation(reservation);
                for(Message message: messages){
                    MessageWs messageWs = MessageConverter.fromPojoToXMLType(message);
                    messageWs.setReservationId(message.getReservation().getId());
                    response.getMessages().add(messageWs);
                }
            }
        }
        response.getAccommodationUnitWs().addAll(accommodationUnitWs);
        return response;
    }

    @PayloadRoot(namespace = AgentEndpoint.NAMESPACE_URI, localPart = "createAccommodationRequest")
    @ResponsePayload
    public CreateAccommodationResponse createAccommodation(@RequestPayload CreateAccommodationRequest request){
        CreateAccommodationResponse response = new CreateAccommodationResponse();
        List<AdditionalServices> additionalServicesList  = new ArrayList<>();
        for(AdditionalServicesWs additionalServices: request.getAccommodationUnit().getAdditionalServices()){
            AdditionalServices services =accommodationOptionService.getServiceByName(additionalServices.getName());
            if(services==null)
                throw new BadRequestException("Additional services cannot be null");
            additionalServicesList.add(services);
        }
        AccommodationUnitWs pom = request.getAccommodationUnit();
        AccommodationType accommodationType = accommodationOptionService.getTypeByName(pom.getAccommodationType().getTypeName());
        if(accommodationType==null)
            throw new BadRequestException("Type cannot be null");
        AccommodationCategory accommodationCategory = accommodationOptionService.getCategoryByName(pom.getCategory().getCategoryName());
        if(accommodationCategory==null)
            throw new BadRequestException("Category cannot be null");
        Agent agent = agentRepository.getByEmailIgnoreCase(pom.getAgent().getEmail());
        if(agent==null)
            throw new BadRequestException("Agent cannot be null");
        AccommodationUnit accommodationUnit = new AccommodationUnit(pom.getPlace(),pom.getDescription(),
                pom.getCapacity(),accommodationType,accommodationCategory,additionalServicesList,agent);
        accommodationUnit = accommodationRepository.save(accommodationUnit);
        response.setIdAccommodation(accommodationUnit.getId());
        List<Long> imageIds = new ArrayList<>();
        for(String src: request.getImageSrc()){
            AccommodationPhoto accommodationPhoto = new AccommodationPhoto(accommodationUnit,src);
            accommodationPhoto = accommodationPhotoRepository.save(accommodationPhoto);
            imageIds.add(accommodationPhoto.getId());
        }
        response.getIdImage().addAll(imageIds);

        Pricing pricing = request.getPricing();
        AccommodationPricing accommodationPricing = new AccommodationPricing(accommodationUnit,pricing.getJanuary(),
                pricing.getFebruary(),pricing.getMarch(),pricing.getApril(),pricing.getMay(),pricing.getJune(),pricing.getJuly()
                ,pricing.getAugust(),pricing.getSeptember(),pricing.getOctober(),pricing.getNovember(),pricing.getDecember());
        accommodationPricing = accommodationPricingRepository.save(accommodationPricing);
        response.setIdPricing(accommodationPricing.getId());
        return response;
    }



}
