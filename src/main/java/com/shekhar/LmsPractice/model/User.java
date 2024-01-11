package com.shekhar.LmsPractice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")

public class User {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long userId;

    @Column(name="user_name")
    private String name;
    @Column(name="date_of_birth")
    private String dateOfBirth;
    @Column(name = "address")
    private String address;
}