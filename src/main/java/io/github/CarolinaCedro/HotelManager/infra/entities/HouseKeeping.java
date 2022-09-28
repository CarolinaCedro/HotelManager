package io.github.CarolinaCedro.HotelManager.infra.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseKeeping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "phoneNo")
    private String PhoneNo;
    @Column(name = "location")
    private String Location;

//    @OneToMany(mappedBy = "receptionist", fetch = FetchType.LAZY)
//    private List<Bill>bill = new ArrayList<>();
}

