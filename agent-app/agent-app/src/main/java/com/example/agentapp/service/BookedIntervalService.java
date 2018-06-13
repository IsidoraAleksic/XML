package com.example.agentapp.service;

import com.example.agentapp.domain.BookedInterval;

import java.util.List;

public interface BookedIntervalService {

    BookedInterval bookInterval(BookedInterval bookedInterval);

    List<BookedInterval> getByUnitId(long id);
}

