package io.github.CarolinaCedro.HotelManager.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receptionist {
    private String Name;
    private Integer Id;
    private Integer PhoneNo;
    private String Location;
}
