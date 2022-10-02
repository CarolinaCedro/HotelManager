package io.github.CarolinaCedro.HotelManager.dto.GuestInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryInput {
    private String type;
    private String status;
    private Long manager;
}

