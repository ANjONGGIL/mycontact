package com.fastcampus.javaallinone.project3.mycontact.domain;

import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private  int age;

    private String hobby;

    private String bloodTypes;


    private String address;

    @Embedded
    @Valid
    private Birthday birthday;

    private String job;

    @ToString.Exclude
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @ToString.Exclude
    private Block block;



    public Person(String name, int age, String bloodTypes) {
        this.name = name;
        this.age = age;
        this.bloodTypes = bloodTypes;
    }
}
