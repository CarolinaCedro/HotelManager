package io.github.CarolinaCedro.HotelManager.service;

import io.github.CarolinaCedro.HotelManager.domain.entities.Chef;
import io.github.CarolinaCedro.HotelManager.domain.entities.Guest;
import io.github.CarolinaCedro.HotelManager.domain.repository.ChefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class ChefService {
    @Autowired
    ChefRepository chefRepository;

    public List<Chef> getChef() {
        List<Chef> list = chefRepository.findAll();
        return list;
    }

    public Optional<Chef> getById(Long id) {
        return chefRepository.findById(id);
    }

    public Chef save(Chef chef) {
        return chefRepository.save(chef);
    }

    public Chef update(Chef chef, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");
        Optional<Chef> optional = chefRepository.findById(id);
        if (optional.isPresent()) {
            Chef db = optional.get();
            db.setName(chef.getName());
            db.setLocation(chef.getLocation());
            chefRepository.save(db);
            return db;
        }
        return null;
    }

    public void deleteById(Long id) {
        chefRepository.deleteById(id);
    }
}
