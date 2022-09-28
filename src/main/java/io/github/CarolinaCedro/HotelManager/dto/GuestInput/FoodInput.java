package io.github.CarolinaCedro.HotelManager.dto.GuestInput;

import io.github.CarolinaCedro.HotelManager.infra.entities.FoodItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodInput {

    private String Name;
    private Long chefe;
}
