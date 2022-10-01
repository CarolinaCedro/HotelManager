package io.github.CarolinaCedro.HotelManager.dto.GuestInput;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillInput {

    @NotBlank
    private String guestname;
    @JsonIgnore
    private Long guest;
}
