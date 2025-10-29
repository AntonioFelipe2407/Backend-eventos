package com.eventosdiversos.apiEventos.service;

import com.eventosdiversos.apiEventos.cloudinary.ImageService;
import com.eventosdiversos.apiEventos.domain.address.Address;
import com.eventosdiversos.apiEventos.domain.event.Event;
import com.eventosdiversos.apiEventos.domain.event.EventRequestDTO;
import com.eventosdiversos.apiEventos.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ImageService imageService;

    private AddressService addressService;

    public Event createEvent(EventRequestDTO data) {

        Event newEvent = null;
        newEvent = fromDTO(data, newEvent);
        addressService.associateAddress(data, newEvent); // Instanciando e associando o endereço a um evento
        eventRepository.save(newEvent);
        return newEvent;
    }


    public Event fromDTO(EventRequestDTO dto, Event event) {

        String imgUrl = null;
        if (dto.image() != null) {
            imgUrl = imageService.uploadImg(dto.image(), "imgEvents");
        }

        event.setTitle(dto.title());
        event.setDescription(dto.description());
        LocalDateTime dateTime = Instant.
                ofEpochMilli(dto.date()).
                atZone(ZoneId.systemDefault()).
                toLocalDateTime();
        event.setDate(dateTime);
        event.setImgUrl(imgUrl);
        event.setEventUrl(dto.eventUrl());

        return event;
    }
}
