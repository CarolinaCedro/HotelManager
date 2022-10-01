package io.github.CarolinaCedro.HotelManager.rest.controller;


import io.github.CarolinaCedro.HotelManager.infra.entities.Bill;
import io.github.CarolinaCedro.HotelManager.infra.entities.Guest;
import io.github.CarolinaCedro.HotelManager.infra.repository.BillRepository;
import io.github.CarolinaCedro.HotelManager.infra.repository.GuestRepository;
import io.github.CarolinaCedro.HotelManager.infra.repository.ManagerRepository;
import io.github.CarolinaCedro.HotelManager.service.BillService;
import io.github.CarolinaCedro.HotelManager.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/bills")
public class BillController {


    @Autowired
    GuestRepository guestRepository;

    @Autowired
    BillService billService;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(billService.getBill());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getById(@PathVariable("id") Long id) {
//        return ResponseEntity.ok(service.getById(id));
        //TODO= Passar essa logica pra uma camada abaixo!!! não deixar assim direto
        return guestRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }


    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Bill bill) {
        Bill bill1 = billService.save(bill);
        return ResponseEntity.ok(bill1);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody @Valid Bill bill) {
        bill.setId(id);

        Bill UpdateBill = billService.update(bill, id);
        return UpdateBill != null ?
                ResponseEntity.ok(UpdateBill) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        billService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

}
