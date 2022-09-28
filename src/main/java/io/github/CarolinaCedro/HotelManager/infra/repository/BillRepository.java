package io.github.CarolinaCedro.HotelManager.infra.repository;

import io.github.CarolinaCedro.HotelManager.infra.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {
}
