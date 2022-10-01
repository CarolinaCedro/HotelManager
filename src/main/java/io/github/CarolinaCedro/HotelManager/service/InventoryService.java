package io.github.CarolinaCedro.HotelManager.service;

import io.github.CarolinaCedro.HotelManager.infra.entities.Inventory;
import io.github.CarolinaCedro.HotelManager.infra.repository.InventoryRepository;
import io.github.CarolinaCedro.HotelManager.infra.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;


    public List<Inventory> getInventory() {
        List<Inventory> list = inventoryRepository.findAll();
        return list;
    }


    public Optional<Inventory> getById(Long id) {
        return inventoryRepository.findById(id);
    }

    public Inventory save(Inventory foodItems) {
        return inventoryRepository.save(foodItems);
    }

    public Inventory update(Inventory inventory, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");
        Optional<Inventory> optional = inventoryRepository.findById(id);
        if (optional.isPresent()) {
            Inventory db = optional.get();
            db.setStatus(inventory.getStatus());
            db.setType(inventory.getType());
            inventoryRepository.save(db);
            return db;
        }
        return null;
    }

    public void deleteById(Long id) {
        inventoryRepository.deleteById(id);
    }
}
