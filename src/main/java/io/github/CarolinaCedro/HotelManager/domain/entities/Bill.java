package io.github.CarolinaCedro.HotelManager.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long BillNo;
    @Column(name="guest_name")
    private String GuestName;

//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "receptionist_id",nullable = true)
//    private Receptionist receptionist;

//    @OneToOne(mappedBy = "bill", fetch = FetchType.LAZY)
//    private Guest guest;
}
