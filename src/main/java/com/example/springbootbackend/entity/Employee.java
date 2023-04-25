package com.example.springbootbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="First_name", nullable = false)
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="email")
    private String email;

}
