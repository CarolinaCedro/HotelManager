package io.github.CarolinaCedro.HotelManager.service;

import io.github.CarolinaCedro.HotelManager.infra.entities.HouseKeeping;
import io.github.CarolinaCedro.HotelManager.infra.repository.HouseKeepingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class HouseKeepingService {
    @Autowired
    HouseKeepingRepository houseKeepingRepository;


    public List<HouseKeeping> getHouse() {
        List<HouseKeeping> list = houseKeepingRepository.findAll();
        return list;
    }


    public Optional<HouseKeeping> getById(Long id) {
        return houseKeepingRepository.findById(id);
    }

    public HouseKeeping save(HouseKeeping houseKeeping) {
        return houseKeepingRepository.save(houseKeeping);
    }

    public HouseKeeping update(HouseKeeping houseKeeping, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");
        Optional<HouseKeeping> optional = houseKeepingRepository.findById(id);
        if (optional.isPresent()) {
            HouseKeeping db = optional.get();
            db.setName(houseKeeping.getName());
            db.setLocation(houseKeeping.getLocation());
            houseKeepingRepository.save(db);
            return db;
        }
        return null;
    }

    public void deleteById(Long id) {
        houseKeepingRepository.deleteById(id);
    }
}
