package io.github.CarolinaCedro.HotelManager.domain.repository;

import io.github.CarolinaCedro.HotelManager.domain.entities.Guest;
import io.github.CarolinaCedro.HotelManager.domain.entities.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist,Long> {
}