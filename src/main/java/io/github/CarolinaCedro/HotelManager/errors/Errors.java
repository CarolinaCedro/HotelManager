package io.github.CarolinaCedro.HotelManager.errors;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Errors {

    private Integer status;
    private LocalDate dataHora;
    private String titulo;
    private List<Campo> campos;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Campo{
        private String nome;
        private String msg;
    }
}
