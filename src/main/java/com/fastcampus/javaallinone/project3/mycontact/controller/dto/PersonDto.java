package com.fastcampus.javaallinone.project3.mycontact.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class PersonDto {
    @NotBlank(message = "이름은 필수 정보 입니다.")
    private String name;
    private String hobby;
    private String address;
    private String job;
    private LocalDate birthday;
    private String phoneNumber;
}
