package io.github.CarolinaCedro.HotelManager.rest.controller;

import io.github.CarolinaCedro.HotelManager.domain.entities.Bill;
import io.github.CarolinaCedro.HotelManager.domain.entities.Chef;
import io.github.CarolinaCedro.HotelManager.service.BillService;
import io.github.CarolinaCedro.HotelManager.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/bills")
public class BillController {

    @Autowired
    BillService service;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(service.getBill());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Bill bill) {
        Bill s = service.save(bill);
        URI location = getUri(s.getBillNo());
        return ResponseEntity.created(location).build();
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Bill bill) {
//        bill.setBillNo(id);
//
//        Bill UpdateGuest = service.update(bill, id);
//        return UpdateGuest != null ?
//                ResponseEntity.ok(UpdateGuest) :
//                ResponseEntity.notFound().build();
//    }

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
