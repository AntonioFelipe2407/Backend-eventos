package com.eventosdiversos.apiEventos.repository;

import com.eventosdiversos.apiEventos.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {


}
