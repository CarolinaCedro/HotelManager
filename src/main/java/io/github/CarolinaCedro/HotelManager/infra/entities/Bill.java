package io.github.CarolinaCedro.HotelManager.infra.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "guest_id")
//    private Guest guest;
}
