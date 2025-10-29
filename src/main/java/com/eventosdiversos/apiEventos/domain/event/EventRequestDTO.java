package com.eventosdiversos.apiEventos.domain.event;

import org.springframework.web.multipart.MultipartFile;

public record EventRequestDTO(String title,
                              String description,
                              Long date,
                              String state,
                              String city,
                              MultipartFile image,
                              String eventUrl) {
}
