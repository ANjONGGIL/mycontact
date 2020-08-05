package com.fastcampus.javaallinone.project3.mycontact.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Block {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    private String reason;

    private LocalDate startDate;

    private LocalDate endDate;

    public Block(String name) {
        this.name = name;
    }
}
