package com.huabai.realestate.offer1.app.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TitleCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "title_id")
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String officerName;
    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "titleAddr_id",
            referencedColumnName = "titleAddr_id"
    )
    private TitleAddress address;
}
