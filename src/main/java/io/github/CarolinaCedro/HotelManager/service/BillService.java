package io.github.CarolinaCedro.HotelManager.service;



import io.github.CarolinaCedro.HotelManager.infra.entities.Bill;
import io.github.CarolinaCedro.HotelManager.infra.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

    public List<Bill> getHouse() {
         List<Bill> list = billRepository.findAll();
        return list;
    }


    public List<Bill> getBill() {
        List<Bill> list = billRepository.findAll();
        return list;
    }


    public Optional<Bill> getById(Long id) {
        return billRepository.findById(id);
    }

    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }


    public Bill update(Bill bill, Long id) {
        Assert.notNull(id, "Não foi possivel atualizar o registro");
        Optional<Bill> optional = billRepository.findById(id);
        if (optional.isPresent()) {
            Bill db = optional.get();
            db.setName(bill.getName());
            return db;
        }
        return null;
    }

    public void deleteById(Long id) {
        billRepository.deleteById(id);
    }
}
