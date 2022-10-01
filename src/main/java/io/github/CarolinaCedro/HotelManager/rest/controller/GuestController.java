package io.github.CarolinaCedro.HotelManager.rest.controller;
import io.github.CarolinaCedro.HotelManager.dto.GuestInput.GuestInput;
import io.github.CarolinaCedro.HotelManager.infra.entities.Bill;
import io.github.CarolinaCedro.HotelManager.infra.entities.Guest;
import io.github.CarolinaCedro.HotelManager.infra.entities.Manager;
import io.github.CarolinaCedro.HotelManager.infra.repository.BillRepository;
import io.github.CarolinaCedro.HotelManager.infra.repository.GuestRepository;
import io.github.CarolinaCedro.HotelManager.infra.repository.ManagerRepository;
import io.github.CarolinaCedro.HotelManager.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/guests")
public class GuestController {

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
    public ResponseEntity save(@RequestBody @Valid GuestInput guestInput) {

        Optional<Manager> manager = managerRepository.findById(guestInput.getManager());
        Optional<Bill> bill = billRepository.findById(guestInput.getBill());

        Guest guest = new Guest(
                guestInput.getName(), guestInput.getPhoneno(),
                guestInput.getAddress(), guestInput.getRoomno(), manager.get(), bill.get());

        Guest s = service.save(guest);

        URI location = getUri(guest.getId());
        return ResponseEntity.created(location).build();

    }

        @PutMapping("/{id}")
        public ResponseEntity update (@PathVariable Long id, @RequestBody @Valid Guest guest){
            guest.setId(id);

            Guest UpdateGuest = service.update(guest, id);
            return UpdateGuest != null ?
                    ResponseEntity.ok(UpdateGuest) :
                    ResponseEntity.notFound().build();
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public ResponseEntity<Void> delete (@PathVariable Long id){
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        private URI getUri (Long id){
            return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(id).toUri();
        }
    }


