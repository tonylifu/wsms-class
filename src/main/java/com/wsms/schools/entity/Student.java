package com.wsms.schools.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;

    @Column(name = "entryclassassigned")
    private String entryClassAssigned;
//    private LinkedHashSet<String> scores_sId = new LinkedHashSet<>();
//    private LinkedHashSet<String> paymentIdSet = new LinkedHashSet<>();
//    private LinkedHashSet<String> summaryIdSet = new LinkedHashSet<>();
//    private LinkedHashSet<String> annualSummaryIdSet = new LinkedHashSet<>();
//    private LinkedHashSet<String> annualScoresTotalIdSet = new LinkedHashSet<>();
    @Column(name = "surname")
    private String surName;
    @Column(name = "othernames")
    private String otherNames;
    @Column(name = "placeofbirth")
    private String placeOfBirth;
    private String nationality;
    private String state;
    private String lga;
    private String village;
    private String address;
    @Column(name = "fathername")
    private String fatherName;
    @Column(name = "fatherphone")
    private String fatherPhone;
    @Column(name = "fatheroccupation")
    private String fatherOccupation;
    @Column(name = "fatherreligion")
    private String fatherReligion;
    @Column(name = "mothername")
    private String motherName;
    @Column(name = "motherphone")
    private String motherPhone;
    @Column(name = "motheroccupation")
    private String motherOccupation;
    @Column(name = "motherreligion")
    private String motherReligion;
    @Column(name = "guardianname")
    private String guardianName;
    @Column(name = "guardianphone")
    private String guardianPhone;
    @Column(name = "guardianoccupation")
    private String guardianOccupation;
    @Column(name = "guardianreligion")
    private String guardianReligion;
    @Column(name = "previousschool")
    private String previousSchool;
    @Column(name = "lastclass")
    private String lastClass;
    @Column(name = "ifdisabled")
    private String ifDisabled;
    private String ICE;
    private String status;
    @Column(name = "classoffered")
    private String classOffered;
    @Column(name = "classseeking")
    private String classSeeking;
    private String sex, disability, email, user;
    @Column(name = "entryborderstatus")
    private String entryBorderStatus;
    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;
    @Column(name = "dateofreg")
    private LocalDate dateOfReg;

}