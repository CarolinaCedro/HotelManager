package io.github.CarolinaCedro.HotelManager.infra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "location")
    private String Location;

//    @JsonIgnore
    @ManyToMany
    @JoinTable(name="chefe_has_food", joinColumns=
            {@JoinColumn(name="chef_id")}, inverseJoinColumns=
            {@JoinColumn(name="fooditems_id")})
    private Set<FoodItems> foodItems;


    public Chef(String name, String location, Set<FoodItems> foodItems) {
        Name = name;
        Location = location;
        this.foodItems = foodItems;
    }
}
