package io.github.CarolinaCedro.HotelManager.rest.controller;

import io.github.CarolinaCedro.HotelManager.domain.entities.Guest;
import io.github.CarolinaCedro.HotelManager.domain.entities.Receptionist;
import io.github.CarolinaCedro.HotelManager.service.GuestService;
import io.github.CarolinaCedro.HotelManager.service.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/receptionists")
public class ReceptionistController {

    @Autowired
    ReceptionistService service;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(service.getReceptionist());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Receptionist receptionist) {
        Receptionist s = service.save(receptionist);
        URI location = getUri(s.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Receptionist receptionist) {
        receptionist.setId(id);

        Receptionist UpdateGuest = service.update(receptionist, id);
        return UpdateGuest != null ?
                ResponseEntity.ok(UpdateGuest) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

}
