package com.example.demo.model.dto;

import java.sql.Date;

public class BookFromTo {

    private long unitId;
    private Date from;
    private Date to;

    public BookFromTo() {
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public long getUnitId() {
        return unitId;
    }

    public void setUnitId(long unitId) {
        this.unitId = unitId;
    }
}
