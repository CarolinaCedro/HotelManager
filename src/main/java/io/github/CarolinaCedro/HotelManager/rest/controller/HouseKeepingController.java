package io.github.CarolinaCedro.HotelManager.rest.controller;

import io.github.CarolinaCedro.HotelManager.domain.entities.HouseKeeping;
import io.github.CarolinaCedro.HotelManager.service.HouseKeepingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/houseKeepings")
public class HouseKeepingController {

    @Autowired
    HouseKeepingService service;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(service.getHouse());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody HouseKeeping houseKeeping) {
        HouseKeeping s = service.save(houseKeeping);
        URI location = getUri(s.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody HouseKeeping houseKeeping) {
        houseKeeping.setId(id);
        HouseKeeping UpdateHouse = service.update(houseKeeping, id);
        return UpdateHouse != null ?
                ResponseEntity.ok(UpdateHouse) :
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
