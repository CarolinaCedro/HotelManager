package io.github.CarolinaCedro.HotelManager.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rooms {
    private Long RoomNo;
    private String Location;
}
