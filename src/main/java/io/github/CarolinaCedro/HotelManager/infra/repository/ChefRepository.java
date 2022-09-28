package io.github.CarolinaCedro.HotelManager.infra.repository;

import io.github.CarolinaCedro.HotelManager.infra.entities.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefRepository extends JpaRepository<Chef,Long> {
}
