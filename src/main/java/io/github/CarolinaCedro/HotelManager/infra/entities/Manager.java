package io.github.CarolinaCedro.HotelManager.infra.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "manager")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "phoneno")
    private String PhoneNo;
    @Column(name = "location")
    private String Location;


    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    private List<Guest> guest = new ArrayList<>();
}
