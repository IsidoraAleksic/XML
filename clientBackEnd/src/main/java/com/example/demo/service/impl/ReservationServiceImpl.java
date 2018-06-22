package com.example.demo.service.impl;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.ConflictException;
import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.Message;
import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    MessageRepository messageRepository;

    @Override
    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void delete(Reservation reservation) {

        reservationRepository.delete(reservation);
    }

    @Override
    public Reservation getById(Long id) {
        return reservationRepository.getById(id);
    }

    @Override
    public Date toDate(String date) {
        java.util.Date toDate = null;
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            toDate = sdf1.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(toDate.getTime());
            return sqlDate;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reservation> getByAccommodationUnit(AccommodationUnit accommodationUnit) {
        return reservationRepository.getByAccommodationUnit(accommodationUnit);
    }

    @Override
    public void reserve(Reservation reservation) {
        if(reservation==null){
            throw new BadRequestException("Reservation must not be null");
        }
//        if(!check(reservation))
//            throw new ConflictException("Reservation exists");
        User user = authenticationService.getLoggedInUser();
        if(user==null){
            throw new BadRequestException("User must not be null");
        }
        reservation.setUser(user);
        reservation.setConfirmed(false);
        save(reservation);

    }

    @Override
    public boolean check(Reservation reservation) {
        int rez = reservationRepository.countByAccommodationUnitAndStartDateBeforeAndEndDateAfter(reservation.getAccommodationUnit(),reservation.getStartDate(),reservation.getEndDate());
        if(rez==0)
            return true;
        return false;
    }

    @Override
    public void cancel(Long id) {
        Reservation reservation = getById(id);
        if(reservation==null){
            throw new BadRequestException("Reservation must not be null");
        }
        User user = authenticationService.getLoggedInUser();
        if(user==null){
            throw new BadRequestException("User must not be null");
        }
        if(reservation.getEndDate().before(Calendar.getInstance().getTime()))
            throw new BadRequestException("Reservation has passed");
        List<Message> messages = messageRepository.getByReservation(reservation);
        if(messages!=null )
            messageRepository.deleteAll(messages);
        delete(reservation);
    }

    @Override
    public int getByAccommodationUnitAndStartDateBeforeAndEndDateAfter(AccommodationUnit accommodationUnit,Date endDate, Date startDate) {
        return reservationRepository.countByAccommodationUnitAndStartDateBeforeAndEndDateAfter(accommodationUnit,endDate,startDate);
    }

    @Override
    public List<Reservation>  getByUser() {
        User user = authenticationService.getLoggedInUser();
        return reservationRepository.getByUser(user);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }


}
