package com.temperies.carcard.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(length = 40, nullable = false)
    protected String name;

    @OneToMany(mappedBy = "company")
    protected Set<CarCard> models = new HashSet<>();

}
