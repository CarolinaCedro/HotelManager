package io.github.CarolinaCedro.HotelManager.infra.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinTable(name="chefe_has_food", joinColumns=
            {@JoinColumn(name="chef_id")}, inverseJoinColumns=
            {@JoinColumn(name="fooditems_id")})
    private FoodItems foodItems;

    public Chef(String name, String location, FoodItems foodItems) {
        Name = name;
        Location = location;
        this.foodItems = foodItems;
    }
}
