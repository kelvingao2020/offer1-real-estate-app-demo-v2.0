package com.huabai.realestate.offer1.app.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "home_id")
    private Long id;
    private String state;
    private int price;
    private int offer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "property_id",
            referencedColumnName = "property_id"
    )
    private Property property;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "escrow_id",
            referencedColumnName = "escrow_id"
    )
    private EscrowCompany escrowCompany;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "title_id",
            referencedColumnName = "title_id"
    )
    private TitleCompany titleCompany;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "listing_id",
            referencedColumnName = "listing_id"
    )
    private ListingAgent listingAgent;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "home_id",
            referencedColumnName = "home_id"
    )
    private List<IncludedItem> includedItems;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "home_id",
            referencedColumnName = "home_id"
    )
    private List<ExcludedItem> excludedItems;
}
