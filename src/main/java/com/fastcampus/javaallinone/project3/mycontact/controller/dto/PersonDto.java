package com.fastcampus.javaallinone.project3.mycontact.controller.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonDto {
    private String name;
    private int age;
    private String hobby;
    private String bloodTypes;
    private String address;
    private String job;
    private LocalDate birthday;
    private String phoneNumber;
}
