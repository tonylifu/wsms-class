package com.wsms.schools.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accountbalance")
public class AccountBalance {

    @Id
    @Column(name = "stdno")
    private String stdNo;
    @Column(name = "surname")
    private String surName;
    @Column(name = "othernames")
    private String otherNames;
    private String user;
    @Column(name = "acctopendate")
    private LocalDate acctOpenDate;
    @Column(name = "lastupdatedate")
    private LocalDate lastUpdateDate;
    private double balance;
    //LinkedHashSet<String> TIDSet = new LinkedHashSet<>();


}