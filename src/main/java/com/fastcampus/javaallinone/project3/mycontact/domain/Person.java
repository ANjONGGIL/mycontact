package com.fastcampus.javaallinone.project3.mycontact.domain;

import com.fastcampus.javaallinone.project3.mycontact.controller.dto.PersonDto;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Where(clause = "deleted = false")
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

    @ColumnDefault("0")
    private boolean deleted;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @ToString.Exclude
    private Block block;



    public Person(String name, int age, String bloodTypes) {
        this.name = name;
        this.age = age;
        this.bloodTypes = bloodTypes;
    }

    public void set(PersonDto personDto){
        if (personDto.getAge() !=0){
            this.setAge(personDto.getAge());
        }
        if (!StringUtils.isEmpty(personDto.getHobby())) {
            this.setHobby(personDto.getHobby());
        }
        if (!StringUtils.isEmpty(personDto.getBloodTypes())) {
            this.setBloodTypes(personDto.getBloodTypes());
        }
        if (!StringUtils.isEmpty(personDto.getAddress())) {
            this.setAddress(personDto.getAddress());
        }
        if (!StringUtils.isEmpty(personDto.getJob())) {
            this.setJob(personDto.getJob());
        }

        if (!StringUtils.isEmpty(personDto.getPhoneNumber())) {
            this.setPhoneNumber(personDto.getPhoneNumber());
        }

    }
}
