package io.github.CarolinaCedro.HotelManager.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
//    @ManyToOne
//    @JoinColumn(name = "categoria_id")
//    private Manager manager;
    private String Name;
    private Integer PhoneNo;
    private String Address;
    private Integer RoomNo;
}
