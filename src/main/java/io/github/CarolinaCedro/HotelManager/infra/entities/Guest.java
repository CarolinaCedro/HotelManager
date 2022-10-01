package io.github.CarolinaCedro.HotelManager.infra.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "id")
    private Long Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "phoneno")
    private String PhoneNo;
    @Column(name = "address")
    private String Address;
    @Column(name = "roomno")
    private String RoomNo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id",nullable = false)
    private Manager manager;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_id")
    private Bill bill;

    public Guest(String name, String phoneNo, String address, String roomNo, Manager manager, Bill bill) {
        Name = name;
        PhoneNo = phoneNo;
        Address = address;
        RoomNo = roomNo;
        this.manager = manager;
        this.bill = bill;
    }
}
