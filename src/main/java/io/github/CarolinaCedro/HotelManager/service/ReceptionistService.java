package io.github.CarolinaCedro.HotelManager.service;

import io.github.CarolinaCedro.HotelManager.infra.entities.HouseKeeping;
import io.github.CarolinaCedro.HotelManager.infra.entities.Receptionist;
import io.github.CarolinaCedro.HotelManager.infra.repository.HouseKeepingRepository;
import io.github.CarolinaCedro.HotelManager.infra.repository.ReceptionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptionistService {
    @Autowired
    ReceptionistRepository receptionistRepository;

    public List<Receptionist> getReceptionist() {
        List<Receptionist> list = receptionistRepository.findAll();
        return list;
    }


    public Optional<Receptionist> getById(Long id) {
        return receptionistRepository.findById(id);
    }

    public Receptionist save(Receptionist receptionist) {
        return receptionistRepository.save(receptionist);
    }

    public Receptionist update(Receptionist receptionist, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");
        Optional<Receptionist> optional = receptionistRepository.findById(id);
        if (optional.isPresent()) {
            Receptionist db = optional.get();
            db.setName(receptionist.getName());
            db.setLocation(receptionist.getLocation());
            receptionistRepository.save(db);
            return db;
        }
        return null;
    }

    public void deleteById(Long id) {
        receptionistRepository.deleteById(id);
    }
}
