package io.github.CarolinaCedro.HotelManager.service;

import io.github.CarolinaCedro.HotelManager.domain.entities.Guest;
import io.github.CarolinaCedro.HotelManager.domain.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    GuestRepository guestRepository;


    public List<Guest> getGuest() {
        List<Guest> list = guestRepository.findAll();
        return list;
    }

//    public List<CarroDto> getCarros() {
//        List<CarroDto> list = rep.findAll().stream().map(CarroDto::create).collect(Collectors.toList());
//        return list;
//    }
}
