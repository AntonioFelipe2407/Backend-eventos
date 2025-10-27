package com.eventosdiversos.apiEventos.repository;

import com.eventosdiversos.apiEventos.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddresRepository extends JpaRepository<Address, UUID> {
}
