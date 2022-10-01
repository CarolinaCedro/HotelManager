package io.github.CarolinaCedro.HotelManager.dto.GuestInput;

import io.github.CarolinaCedro.HotelManager.infra.entities.FoodItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChefInput {
    private String Name;
    private String Location;
    private Long foodItems;
}

