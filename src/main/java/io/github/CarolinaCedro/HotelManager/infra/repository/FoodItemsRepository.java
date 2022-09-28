package io.github.CarolinaCedro.HotelManager.infra.repository;

import io.github.CarolinaCedro.HotelManager.infra.entities.FoodItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemsRepository extends JpaRepository<FoodItems,Long> {
}
