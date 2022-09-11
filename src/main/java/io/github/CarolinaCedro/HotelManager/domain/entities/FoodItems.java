package io.github.CarolinaCedro.HotelManager.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
//@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String Name;
}
