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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String Name;
    private Integer PhoneNo;
    private String Address;
    private Integer RoomNo;

    public Guest(String name, Integer phoneNo, String address, Integer roomNo) {
        Name = name;
        PhoneNo = phoneNo;
        Address = address;
        RoomNo = roomNo;
    }
}
