package com.example.educonnect_platform.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    private Long id;

    @Column(unique = true)
    private String fireBaseUid;

    @Column(unique = true)
    private String userName;
    private String email;
    private String role;

}
