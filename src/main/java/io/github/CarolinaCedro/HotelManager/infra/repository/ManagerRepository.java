package io.github.CarolinaCedro.HotelManager.infra.repository;

import io.github.CarolinaCedro.HotelManager.infra.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long> {
}
