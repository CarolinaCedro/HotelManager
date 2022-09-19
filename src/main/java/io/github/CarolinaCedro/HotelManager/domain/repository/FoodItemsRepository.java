package io.github.CarolinaCedro.HotelManager.domain.repository;

import io.github.CarolinaCedro.HotelManager.domain.entities.Chef;
import io.github.CarolinaCedro.HotelManager.domain.entities.FoodItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemsRepository extends JpaRepository<FoodItems,Long> {
}
