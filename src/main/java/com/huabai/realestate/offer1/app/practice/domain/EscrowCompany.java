package com.huabai.realestate.offer1.app.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class EscrowCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "escrow_id")
    private Long id;
    private String name;
    private String phone;
    private String email;

    private String officerName;
    private String type;

//    @OneToOne(
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            mappedBy = "escrowCompany"
//    )
//    private Home home;



    @OneToOne(
            cascade = CascadeType.ALL
            //fetch = FetchType.LAZY
            //optional = false
    )
    @JoinColumn(
            name = "escrowAddr_id",
            referencedColumnName = "escrowAddr_id"
    )
    private EscrowAddress address;
}
