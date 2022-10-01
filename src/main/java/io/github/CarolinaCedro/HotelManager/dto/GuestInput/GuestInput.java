package io.github.CarolinaCedro.HotelManager.dto.GuestInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestInput {

    @NotBlank
    @Size(max = 100)
    private String name;
    @NotBlank
    @Size(max = 30)
    private String phoneno;
    @NotBlank
    @Size(max = 100)
    private String address;
    @NotBlank
    @Size(max = 10)
    private String roomno;
    @NotNull
    private Long manager;
    @NotNull
    private Long bill;
}
