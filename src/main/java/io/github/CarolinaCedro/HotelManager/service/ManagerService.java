package io.github.CarolinaCedro.HotelManager.service;

import io.github.CarolinaCedro.HotelManager.infra.entities.Manager;
import io.github.CarolinaCedro.HotelManager.infra.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    ManagerRepository managerRepository;


    public List<Manager> getManager() {
        List<Manager> list = managerRepository.findAll();
        return list;
    }


    public Optional<Manager> getById(Long id) {
        return managerRepository.findById(id);
    }


    public Manager save(Manager manager) {
        return managerRepository.save(manager);
    }

    public Manager update(Manager manager, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");
        Optional<Manager> optional = managerRepository.findById(id);
        if (optional.isPresent()) {
            Manager db = optional.get();
            db.setName(manager.getName());
            db.setPhoneNo(manager.getPhoneNo());
            db.setLocation(manager.getLocation());
            managerRepository.save(db);
            return db;
        }
        return null;
    }

    public void deleteById(Long id) {
        managerRepository.deleteById(id);
    }
}
