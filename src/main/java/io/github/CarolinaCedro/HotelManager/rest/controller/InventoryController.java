package io.github.CarolinaCedro.HotelManager.rest.controller;


import io.github.CarolinaCedro.HotelManager.dto.GuestInput.ReceptionistInput;
import io.github.CarolinaCedro.HotelManager.infra.entities.Bill;
import io.github.CarolinaCedro.HotelManager.infra.entities.Inventory;
import io.github.CarolinaCedro.HotelManager.infra.entities.Receptionist;
import io.github.CarolinaCedro.HotelManager.infra.repository.BillRepository;
import io.github.CarolinaCedro.HotelManager.service.InventoryService;
import io.github.CarolinaCedro.HotelManager.service.ReceptionistService;
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

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(inventoryService.getInventory());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(inventoryService.getById(id));
    }


//    @PostMapping
//    public ResponseEntity save(@RequestBody @Valid ReceptionistInput receptionistInput) {
//
//
//
//    }

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
