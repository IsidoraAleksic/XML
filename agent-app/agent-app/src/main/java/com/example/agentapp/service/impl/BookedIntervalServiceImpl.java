package com.example.agentapp.service.impl;

import com.example.agentapp.domain.BookedInterval;
import com.example.agentapp.repository.BookedIntervalRepository;
import com.example.agentapp.service.BookedIntervalService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookedIntervalServiceImpl implements BookedIntervalService {

    private BookedIntervalRepository bookedIntervalRepository;

    public BookedIntervalServiceImpl(BookedIntervalRepository bookedIntervalRepository) {
        this.bookedIntervalRepository = bookedIntervalRepository;
    }

    @Override
    public BookedInterval bookInterval(BookedInterval bookedInterval) {
        return bookedIntervalRepository.save(bookedInterval);
    }

    @Override
    public List<BookedInterval> getByUnitId(long id) {
        return bookedIntervalRepository.getByAccommodationUnit_Id(id);
    }
}
