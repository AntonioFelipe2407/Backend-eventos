package com.eventosdiversos.apiEventos.controller;

import com.eventosdiversos.apiEventos.domain.event.Event;
import com.eventosdiversos.apiEventos.domain.event.EventRequestDTO;
import com.eventosdiversos.apiEventos.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping(consumes = "multipart/data")
    public ResponseEntity<Event> createEvent(@RequestParam ("title") String title,
                                      @RequestParam ("description") String description,
                                      @RequestParam("date") Long date,
                                      @RequestParam("state") String state,
                                      @RequestParam("city") String city,
                                      @RequestParam("image")MultipartFile image,
                                      @RequestParam("eventUrl") String eventUrl){
        EventRequestDTO eventRequestDTO = new EventRequestDTO(title, description, date, state, city, image, eventUrl);
        Event newEvent = eventService.createEvent(eventRequestDTO); // Retorna o evento criado
        return ResponseEntity.ok(newEvent);
    }

}
