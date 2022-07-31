package com.dimple.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 64)
    private String email;

    @Column(nullable = false, length = 64)
    private String firstName;

    @Column(nullable = false, length = 64)
    private String lastName;

    @Column(length = 128)
    private String password;

}
