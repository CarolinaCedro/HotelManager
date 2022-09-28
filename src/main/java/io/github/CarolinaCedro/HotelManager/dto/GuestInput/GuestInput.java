package io.github.CarolinaCedro.HotelManager.dto.GuestInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestInput {

    private String name;
    private String phoneno;
    private String address;
    private String roomno;
    private Long manager;
    private Long bill;
}
