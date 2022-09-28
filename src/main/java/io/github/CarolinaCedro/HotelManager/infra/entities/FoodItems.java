package io.github.CarolinaCedro.HotelManager.infra.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @ManyToOne
    @JoinTable(name="chefe_has_food", joinColumns=
            {@JoinColumn(name="chefe_id")}, inverseJoinColumns=
            {@JoinColumn(name="fooditems_id")})
    private FoodItems foodItems;
}
