package io.github.CarolinaCedro.HotelManager.service;

import io.github.CarolinaCedro.HotelManager.domain.entities.Guest;
import io.github.CarolinaCedro.HotelManager.domain.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GuestService {
    @Autowired
    GuestRepository guestRepository;


    public List<Guest> getGuest() {
        List<Guest> list = guestRepository.findAll();
        return list;
    }


    public Optional<Guest> getById(Long id) {
        return guestRepository.findById(id);
    }

    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest update(Guest guest, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");
        Optional<Guest> optional = guestRepository.findById(id);
        if (optional.isPresent()) {
            Guest db = optional.get();
            db.setName(guest.getName());
            db.setAddress(guest.getAddress());
            db.setRoomNo(guest.getRoomNo());
            db.setPhoneNo(guest.getPhoneNo());
            guestRepository.save(db);
            return db;
        }
        return null;
    }

    public void deleteById(Long id) {
        guestRepository.deleteById(id);
    }
}
