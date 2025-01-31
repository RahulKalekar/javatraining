package com.bank.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @NotEmpty
    @Column(name="name")
    private String name;

    @NotNull
    @Column(name="balance")
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

}

