package com.huabai.realestate.offer1.app.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ExcludedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excludedItem_id")
    private Long id;
    private String name;
    private String listing;

//    @ManyToOne(
//            cascade = CascadeType.ALL
//    )
//    @JoinColumn(
//            name = "home_id",
//            referencedColumnName = "home_id"
//    )
//    private Home home;

}