package io.github.CarolinaCedro.HotelManager.rest.controller;


import io.github.CarolinaCedro.HotelManager.infra.entities.Bill;
import io.github.CarolinaCedro.HotelManager.infra.entities.Guest;
import io.github.CarolinaCedro.HotelManager.infra.repository.BillRepository;
import io.github.CarolinaCedro.HotelManager.infra.repository.GuestRepository;
import io.github.CarolinaCedro.HotelManager.infra.repository.ManagerRepository;
import io.github.CarolinaCedro.HotelManager.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/bills")
public class BillController {

    @Autowired
    GuestService service;
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    BillRepository billRepository;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(service.getGuest());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getById(@PathVariable("id") Long id) {
//        return ResponseEntity.ok(service.getById(id));
        //TODO= Passar essa logica pra uma camada abaixo!!! não deixar assim direto
        return guestRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }


    @PostMapping
    public ResponseEntity save(@RequestBody Bill bill) {
        return ResponseEntity.ok(bill);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Guest guest) {
        guest.setId(id);

        Guest UpdateGuest = service.update(guest, id);
        return UpdateGuest != null ?
                ResponseEntity.ok(UpdateGuest) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

}
