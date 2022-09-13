package com.huabai.realestate.offer1.app.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "property_id")
    private Long id;
    private String propertyType;
    private int squareFeet;
    private int numberBedrooms;
    private int numberBaths;
    private String description;
    private String ownerType;
    private String primaryImageUrl;

    @OneToOne(
            cascade = CascadeType.ALL
            //fetch = FetchType.LAZY
            //optional = false
    )
    @JoinColumn(
            name = "propertyAddr_id",
            referencedColumnName = "propertyAddr_id"
    )
    private PropertyAddress address;

    @OneToOne(
            cascade = CascadeType.ALL
            //fetch = FetchType.LAZY
            //optional = false
    )
    @JoinColumn(
            name = "primaryOwner_id",
            referencedColumnName = "primaryOwner_id"
    )
    private PrimaryOwner primaryOwner;
}
