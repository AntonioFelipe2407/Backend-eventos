package com.eventosdiversos.apiEventos.service;

import com.eventosdiversos.apiEventos.domain.address.Address;
import com.eventosdiversos.apiEventos.domain.event.Event;
import com.eventosdiversos.apiEventos.domain.event.EventRequestDTO;
import com.eventosdiversos.apiEventos.repository.AddresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddresRepository addresRepository;

    public Address associateAddress(EventRequestDTO data, Event event){

        Address newAddress = null;
        newAddress.setUf(data.state());
        newAddress.setCity(data.city());
        newAddress.setEvent(event);
        addresRepository.save(newAddress);
        return newAddress;
    }
}
