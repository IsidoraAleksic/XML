package com.example.agentapp.event;

import org.springframework.context.ApplicationEvent;

import java.util.List;

public class OnCreateAccommodationEvent extends ApplicationEvent {

    private long tempUnitId;
    private List<String> fileNames;

    public OnCreateAccommodationEvent(long tempUnitId, List<String> fileNames) {
        super(tempUnitId);
        this.tempUnitId = tempUnitId;
        this.fileNames = fileNames;
    }

    public long getTempUnitId() {
        return tempUnitId;
    }

    public List<String> getFileNames() {
        return fileNames;
    }
}
