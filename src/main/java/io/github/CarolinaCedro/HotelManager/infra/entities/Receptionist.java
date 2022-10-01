package io.github.CarolinaCedro.HotelManager.infra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receptionist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phoneno")
    private Integer phoneno;
    @Column(name = "location")
    private String location;


    @OneToMany
    @JoinColumn(name = "bill_id")
    private List<Bill> bill;

    public Receptionist(String name, Integer phoneno, String location, List<Bill> bill) {
        this.name = name;
        this.phoneno = phoneno;
        this.location = location;
        this.bill = bill;
    }
}
