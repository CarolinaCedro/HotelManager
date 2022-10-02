package io.github.CarolinaCedro.HotelManager.infra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String status;

    @JsonIgnore
    @OneToOne
    @JoinColumn
    private Manager manager;

    public Inventory(String type, String status, Manager manager) {
        this.type = type;
        this.status = status;
        this.manager = manager;
    }
}
