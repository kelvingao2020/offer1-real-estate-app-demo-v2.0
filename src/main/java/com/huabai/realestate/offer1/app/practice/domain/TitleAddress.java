package com.huabai.realestate.offer1.app.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TitleAddress implements Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "titleAddr_id")
    private Long id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;
}
