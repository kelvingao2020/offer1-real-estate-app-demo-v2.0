package com.huabai.realestate.offer1.app.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PrimaryOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "primaryOwner_id")
    private Long id;

    @OneToOne(
            cascade = CascadeType.ALL
            //fetch = FetchType.LAZY
            //optional = false
    )
    @JoinColumn(
            name = "primary_user_Id",
            referencedColumnName = "primary_user_Id"
    )
    private PrimaryUser user;
}
