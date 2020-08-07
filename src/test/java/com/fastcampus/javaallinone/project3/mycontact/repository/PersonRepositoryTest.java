package com.fastcampus.javaallinone.project3.mycontact.repository;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void findByName(){
        List<Person> people = personRepository.findByName("tony");

        Person person = people.get(0);

        assertAll(
                ()->assertThat(person.getName(),is("tony")),
                ()->assertThat(person.getHobby(),is("reading")),
                ()->assertThat(person.getAddress(),is("Seoul")),
                ()->assertThat(person.getJob(),is("officer")),
                ()->assertThat(person.getPhoneNumber(),is("010-2222-5555")),
                ()->assertThat(person.isDeleted(),is(false))
        );
    }

    @Test
    void findByNameIfDeleted(){
        List<Person> people = personRepository.findByName("andrew");
        assertThat(people.size(),is(0));
    }

    @Test
    void findByMonthOfBirthday(){
        List<Person> people =personRepository.findByMonthOfBirthday(7);

        assertThat(people.size(),is(2));


        assertAll(
                ()->assertThat(people.get(0).getName(),is("david")),
                ()->assertThat(people.get(1).getName(),is("tony"))
        );
    }
    @Test
    void findPeopleDeleted(){
        List<Person> people = personRepository.findPersonDeleted();

        assertThat(people.size(),is(1));
        assertThat(people.get(0).getName(),is("andrew"));
    }

}