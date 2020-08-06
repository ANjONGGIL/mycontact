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
    void crud(){
        Person person = new Person();
        person.setName("john");
        person.setAge(10);
        person.setBloodTypes("A");

        personRepository.save(person);

        List<Person> result = personRepository.findByName("john");

        assertThat(result.get(0).getName(),is("john"));

    }

    @Test
    void findByBloodTypes(){
        List<Person> result = personRepository.findByBloodTypes("A");

        assertThat(result.get(0).getName(),is("martine"));
        assertThat(result.get(1).getName(),is("benny"));





    }

    @Test
    void findByBirthdayBetween(){

        List<Person> result = personRepository.findByMonthOfBirthday(8);

        result.forEach(System.out::println);
    }
    private void givenPerson(String name, int age,String bloodType){
        givenPerson(name,age,bloodType,null);
    }
    private void givenPerson(String name, int age,String bloodType,LocalDate birthday){
        Person person = new Person(name,age,bloodType);
        person.setBirthday(new Birthday(birthday));
        personRepository.save(person);
    }


}