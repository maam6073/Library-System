package com.rmsoft_test.LibrarySystem.user.entity;

import com.rmsoft_test.LibrarySystem.common.BaseEntity;
import lombok.*;


import javax.persistence.*;

@Table(name = "users")
@Entity @Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false, length = 100)
    @Getter @Setter
    private String password;

    @Column(nullable = false)
    private String name;


    @Enumerated(EnumType.STRING)
    private Role role;



}
