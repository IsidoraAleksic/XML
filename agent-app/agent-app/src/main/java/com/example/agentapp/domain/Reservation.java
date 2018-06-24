package com.example.agentapp.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
@NoArgsConstructor
public class Reservation implements Serializable{

    @Id
    private long id;

    private Date fromDate;
    private Date toDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accommodation_unit_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AccommodationUnit accommodationUnit;

    private boolean confirmed;

    public Reservation(Date fromDate, Date toDate, AccommodationUnit accommodationUnit) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.accommodationUnit = accommodationUnit;
        this.confirmed = false;
    }

    public Reservation(long id, Date fromDate, Date toDate, AccommodationUnit accommodationUnit) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.accommodationUnit = accommodationUnit;
        this.confirmed = false;
    }
}
