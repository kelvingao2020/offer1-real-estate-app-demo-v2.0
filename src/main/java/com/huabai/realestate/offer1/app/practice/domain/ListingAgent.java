package com.huabai.realestate.offer1.app.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ListingAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "listing_id")
    private Long id;
    private String licenseNumber;
    private String licenseState;
    private String status;

//    @OneToOne(
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            mappedBy = "listingAgent"
//    )
//    private Home home;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "listing_user_Id",
            referencedColumnName = "listing_user_Id"
    )
    private ListingUser user;
}
