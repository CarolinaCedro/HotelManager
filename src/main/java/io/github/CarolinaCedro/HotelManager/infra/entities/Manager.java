package io.github.CarolinaCedro.HotelManager.infra.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
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


    @OneToMany
    private List<Inventory> inventories = new ArrayList<>();

    public Manager(String name, String phoneNo, String location, List<Inventory> inventories) {
        Name = name;
        PhoneNo = phoneNo;
        Location = location;
        this.inventories = inventories;
    }
}
