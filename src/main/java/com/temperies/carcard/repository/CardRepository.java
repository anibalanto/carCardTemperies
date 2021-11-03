package com.temperies.carcard.repository;

import com.temperies.carcard.model.CarCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface CardRepository extends JpaRepository<CarCard, Long> {
}
