package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class BookedInterval implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private Date fromDate;
    private Date toDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accommodation_unit_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private AccommodationUnit accommodationUnit;

    public BookedInterval(Date fromDate, Date toDate, AccommodationUnit accommodationUnit) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.accommodationUnit = accommodationUnit;
    }

    public BookedInterval() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public AccommodationUnit getAccommodationUnit() {
        return accommodationUnit;
    }

    public void setAccommodationUnit(AccommodationUnit accommodationUnit) {
        this.accommodationUnit = accommodationUnit;
    }
}
