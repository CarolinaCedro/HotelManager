package io.github.CarolinaCedro.HotelManager.rest.controller;

import io.github.CarolinaCedro.HotelManager.dto.GuestInput.ChefInput;
import io.github.CarolinaCedro.HotelManager.infra.entities.Chef;
import io.github.CarolinaCedro.HotelManager.infra.entities.FoodItems;
import io.github.CarolinaCedro.HotelManager.infra.repository.ChefRepository;
import io.github.CarolinaCedro.HotelManager.infra.repository.FoodItemsRepository;
import io.github.CarolinaCedro.HotelManager.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/chefs")
public class ChefController {

    @Autowired
    ChefService service;
    @Autowired
    FoodItemsRepository foodItemsRepository;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(service.getChef());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ChefInput chefInput) {

        Optional<FoodItems> chefe = foodItemsRepository.findById(chefInput.getFoodItems());

            Set<FoodItems> foods = new HashSet<>();
            Chef chef = new Chef(chefInput.getName(), chefInput.getLocation(), foods);
            Chef s = service.save(chef);
            URI location = getUri(s.getId());
            return ResponseEntity.created(location).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Chef chef) {
        chef.setId(id);

        Chef UpdateGuest = service.update(chef, id);
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
