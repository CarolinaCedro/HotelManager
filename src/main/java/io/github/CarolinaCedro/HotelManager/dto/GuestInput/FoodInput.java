package io.github.CarolinaCedro.HotelManager.dto.GuestInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodInput {
    private Long id;
    private String name;
    private Long chefe;
}

