package com.temperies.carcard.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Clob;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "card")
public class CarCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(length = 40, nullable = false)
    protected String model;

    protected Float maxKmh;

    protected Float cv;

    protected Float tMin;

    protected Float cc;

    protected Integer cantCilindros;

    protected Float peso;

    @ManyToOne
    protected Company company;


    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;


    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    protected Date createdAt = new Date();


}
