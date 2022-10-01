package io.github.CarolinaCedro.HotelManager.dto.GuestInput;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceptionistInput {
    private String name;
    private Integer phoneno;
    private String location;
    private Long bill;
}
