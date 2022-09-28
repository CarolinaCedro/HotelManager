package io.github.CarolinaCedro.HotelManager.infra.repository;

import io.github.CarolinaCedro.HotelManager.infra.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
