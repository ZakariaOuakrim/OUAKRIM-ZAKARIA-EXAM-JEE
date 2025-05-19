package com.zakaria.exam.repositories;

import com.zakaria.exam.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Long> {
}
