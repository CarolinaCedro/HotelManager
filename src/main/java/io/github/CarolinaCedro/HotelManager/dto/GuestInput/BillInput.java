package io.github.CarolinaCedro.HotelManager.dto.GuestInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillInput {
    private String guestname;
    private Long guest;
}
