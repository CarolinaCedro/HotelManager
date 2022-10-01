package io.github.CarolinaCedro.HotelManager.rest.controller;


import io.github.CarolinaCedro.HotelManager.dto.GuestInput.ReceptionistInput;
import io.github.CarolinaCedro.HotelManager.infra.entities.Bill;
import io.github.CarolinaCedro.HotelManager.infra.entities.Receptionist;
import io.github.CarolinaCedro.HotelManager.infra.repository.BillRepository;
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
@RequestMapping("/receptionists")
public class ReceptionistController {

    @Autowired
    ReceptionistService receptionistService;

    @Autowired
    BillRepository billRepository;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(receptionistService.getReceptionist());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(receptionistService.getById(id));
    }


    @PostMapping
    public ResponseEntity save(@RequestBody @Valid ReceptionistInput receptionistInput) {

        Optional<Bill> bill = billRepository.findById(receptionistInput.getBill());

        List<Bill> bills = List.of(bill.get());

        Receptionist receptionist = new Receptionist(receptionistInput.getName(), receptionistInput.getPhoneno(),
                receptionistInput.getLocation(), bills);

        Receptionist save = receptionistService.save(receptionist);
        URI location = getUri(receptionist.getId());
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody @Valid Receptionist receptionist) {
        receptionist.setId(id);

        Receptionist UpdateBill = receptionistService.update(receptionist, id);
        return UpdateBill != null ?
                ResponseEntity.ok(UpdateBill) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        receptionistService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

}
