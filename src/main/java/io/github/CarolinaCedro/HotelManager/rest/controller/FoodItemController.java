package io.github.CarolinaCedro.HotelManager.rest.controller;

import io.github.CarolinaCedro.HotelManager.infra.entities.FoodItems;
import io.github.CarolinaCedro.HotelManager.service.FoodItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/foods")
public class FoodItemController {

    @Autowired
    FoodItemsService service;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(service.getFood());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody FoodItems foodItems) {
        FoodItems s = service.save(foodItems);
        URI location = getUri(s.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody FoodItems foodItems) {
        foodItems.setId(id);

        FoodItems UpdateFood = service.update(foodItems, id);
        return UpdateFood != null ?
                ResponseEntity.ok(UpdateFood) :
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
