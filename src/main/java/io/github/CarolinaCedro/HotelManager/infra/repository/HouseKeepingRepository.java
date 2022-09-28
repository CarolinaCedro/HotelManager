package io.github.CarolinaCedro.HotelManager.infra.repository;


import io.github.CarolinaCedro.HotelManager.infra.entities.HouseKeeping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseKeepingRepository extends JpaRepository<HouseKeeping,Long> {
}
