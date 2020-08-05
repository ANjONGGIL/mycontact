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
        person.setName("martine");
        person.setAge(10);
        person.setBloodTypes("A");

        personRepository.save(person);

        System.out.println(personRepository.findAll());

        List<Person> people = personRepository.findAll();

        assertThat(people.get(0).getName(),is("martine"));

    }

    @Test
    void findByBloodTypes(){
        givenPerson("martine",10,"A",LocalDate.of(1991,8,15));
        givenPerson("david",7,"AB",LocalDate.of(1991,8,15));
        givenPerson("dennis",8,"B",LocalDate.of(1991,8,15));
        givenPerson("jonggil",9,"O",LocalDate.of(1998,4,4));

        List<Person> result = personRepository.findByBloodTypes("A");

        System.out.println(result);


    }

    @Test
    void findByBirthdayBetween(){

        givenPerson("martine",10,"A",LocalDate.of(1991,8,15));
        givenPerson("david",7,"AB",LocalDate.of(1991,8,15));
        givenPerson("dennis",8,"B",LocalDate.of(1991,8,15));
        givenPerson("jonggil",9,"O",LocalDate.of(1998,4,4));
        List<Person> result = personRepository.findByMonthOfBirthday(4);

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