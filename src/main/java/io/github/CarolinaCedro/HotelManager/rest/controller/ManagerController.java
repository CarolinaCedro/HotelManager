package io.github.CarolinaCedro.HotelManager.rest.controller;

import io.github.CarolinaCedro.HotelManager.dto.GuestInput.ManagerInput;
import io.github.CarolinaCedro.HotelManager.infra.entities.Guest;
import io.github.CarolinaCedro.HotelManager.infra.entities.Inventory;
import io.github.CarolinaCedro.HotelManager.infra.entities.Manager;
import io.github.CarolinaCedro.HotelManager.infra.repository.GuestRepository;
import io.github.CarolinaCedro.HotelManager.infra.repository.InventoryRepository;
import io.github.CarolinaCedro.HotelManager.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    ManagerService service;
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    GuestRepository guestRepository;

    @GetMapping()
    public ResponseEntity get() {
        return ResponseEntity.ok(service.getManager());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ManagerInput managerInput) {

        Optional<Inventory> inventory = inventoryRepository.findById(managerInput.getInventories());

        List<Inventory> inventoryList = List.of(inventory.get());

        Manager manager = new Manager(managerInput.getName(), managerInput.getPhoneno(), managerInput.getLocation(),inventoryList);

        Manager save = service.save(manager);
        URI location = getUri(save.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Manager manager) {
        manager.setId(id);

        Manager UpdateManager = service.update(manager, id);
        return UpdateManager != null ?
                ResponseEntity.ok(UpdateManager) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

}
