package io.github.CarolinaCedro.HotelManager.infra.repository;




import io.github.CarolinaCedro.HotelManager.infra.entities.FoodItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodItemsRepository extends JpaRepository<FoodItems,Long> {
//    Optional<List<FoodItems>> findAll(Long foodItems);
}
