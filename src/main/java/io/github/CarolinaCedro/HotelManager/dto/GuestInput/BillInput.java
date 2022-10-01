package io.github.CarolinaCedro.HotelManager.dto.GuestInput;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillInput {
    private String guestname;
    @JsonIgnore
    private Long guest;
}
