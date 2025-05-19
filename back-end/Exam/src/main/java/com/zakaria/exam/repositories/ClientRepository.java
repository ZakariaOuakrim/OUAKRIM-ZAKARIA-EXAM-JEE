package com.zakaria.exam.repositories;

import com.zakaria.exam.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
