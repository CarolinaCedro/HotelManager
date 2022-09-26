package io.github.CarolinaCedro.HotelManager.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "manager")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "phoneno")
    private String PhoneNo;
    @Column(name = "location")
    private String Location;
    @ManyToMany
    @JoinTable(name="manager_has_guest", joinColumns=
            {@JoinColumn(name="manager_id")}, inverseJoinColumns=
            {@JoinColumn(name="guest_id")})
    private List<Guest> guest;
}
