package io.github.CarolinaCedro.HotelManager.rest.controller;


import io.github.CarolinaCedro.HotelManager.dto.GuestInput.InventoryInput;
import io.github.CarolinaCedro.HotelManager.dto.GuestInput.ReceptionistInput;
import io.github.CarolinaCedro.HotelManager.infra.entities.Bill;
import io.github.CarolinaCedro.HotelManager.infra.entities.Inventory;
import io.github.CarolinaCedro.HotelManager.infra.entities.Manager;
import io.github.CarolinaCedro.HotelManager.infra.entities.Receptionist;
import io.github.CarolinaCedro.HotelManager.infra.repository.BillRepository;
import io.github.CarolinaCedro.HotelManager.infra.repository.ManagerRepository;
import io.github.CarolinaCedro.HotelManager.service.InventoryService;
import io.github.CarolinaCedro.HotelManager.service.ReceptionistService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/inventorys")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @Autowired
    ManagerRepository managerRepository;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(inventoryService.getInventory());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(inventoryService.getById(id));
    }


    @PostMapping
    public ResponseEntity save(@RequestBody @Valid InventoryInput inventoryInput) {

        Optional<Manager>manager = managerRepository.findById(inventoryInput.getManager());

        Inventory inventory = new Inventory(inventoryInput.getType(),inventoryInput.getStatus(),manager.get());

        Inventory s = inventoryService.save(inventory);
        URI location = getUri(s.getId());
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody @Valid Inventory inventory) {
        inventory.setId(id);

        Inventory UpdateBill = inventoryService.update(inventory, id);
        return UpdateBill != null ?
                ResponseEntity.ok(UpdateBill) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        inventoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

}
