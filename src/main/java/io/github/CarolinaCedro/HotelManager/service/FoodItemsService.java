package io.github.CarolinaCedro.HotelManager.service;

import io.github.CarolinaCedro.HotelManager.domain.entities.FoodItems;
import io.github.CarolinaCedro.HotelManager.domain.repository.FoodItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemsService {
    @Autowired
    FoodItemsRepository foodItemsRepository;


    public List<FoodItems> getFood() {
        List<FoodItems> list = foodItemsRepository.findAll();
        return list;
    }


    public Optional<FoodItems> getById(Long id) {
        return foodItemsRepository.findById(id);
    }

    public FoodItems save(FoodItems foodItems) {
        return foodItemsRepository.save(foodItems);
    }

    public FoodItems update(FoodItems foodItems, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");
        Optional<FoodItems> optional = foodItemsRepository.findById(id);
        if (optional.isPresent()) {
            FoodItems db = optional.get();
            db.setName(foodItems.getName());
            foodItemsRepository.save(db);
            return db;
        }
        return null;
    }

    public void deleteById(Long id) {
        foodItemsRepository.deleteById(id);
    }
}
