package io.github.CarolinaCedro.HotelManager.infra.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fooditems")
public class FoodItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;

//    @ManyToMany
//    @JoinTable(name="chefe_has_food", joinColumns=
//            {@JoinColumn(name="chef_id")}, inverseJoinColumns=
//            {@JoinColumn(name="fooditems_id")})
//    private List<Chef> chefs;
}
