package com.example.demo.ws;

import com.example.demo.model.AccommodationCategory;
import com.example.demo.model.AccommodationType;
import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.AdditionalServices;
import com.example.demo.model.dto.SearchParameters;
import com.example.demo.repository.AccommodationRepository;
import com.example.demo.service.AccommodationService;
import com.example.demo.service.impl.AccommodationOptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rs.ac.uns.ftn.agenti.*;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class AccommodationEndpoint {

    @Autowired
    AccommodationOptionServiceImpl accommodationOptionService;
    @Autowired
    AccommodationRepository accommodationRepository;

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
            agentWs.setId(au.getId());
            agentWs.setEmail(au.getAgent().getEmail());
            agentWs.setName(au.getAgent().getName());
            agentWs.setSurname(au.getAgent().getSurname());
            agentWs.setPassword(au.getAgent().getPassword());
            agentWs.setRegNumber(au.getAgent().getRegNumber());


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
        }
        response.getAccommodationUnitWs().addAll(accommodationUnitWs);

        return response;
    }

}
