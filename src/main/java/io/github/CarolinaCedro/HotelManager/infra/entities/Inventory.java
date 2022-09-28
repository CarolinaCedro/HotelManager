package io.github.CarolinaCedro.HotelManager.infra.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    private String Type;
    private String Status;
}
