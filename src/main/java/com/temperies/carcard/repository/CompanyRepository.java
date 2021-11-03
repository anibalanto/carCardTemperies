package com.temperies.carcard.repository;

import com.temperies.carcard.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
