package com.jysy.shallwejejubackend.domain.myUser.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String pwd;

    @Column
    private String profileImg;

    @Column
    private String email;

    @Column
    private String schedule;
}
