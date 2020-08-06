package com.fastcampus.javaallinone.project3.mycontact.service;

import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;

    @Test
    void cascadeTest(){

        List<Person> result = personRepository.findAll();

        result.forEach(System.out::println);

        Person person = result.get(3);
//        person.getBlock().setStartDate(LocalDate.now());
//        person.getBlock().setEndDate(LocalDate.now());
//
//        personRepository.save(person);
//        personRepository.findAll().forEach(System.out::println);

//        personRepository.delete(person);
//        personRepository.findAll().forEach(System.out::println);
//        blockRepository.findAll().forEach(System.out::println);
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
    }
    @Test
    void getPeopleByName(){
        List<Person> result = personService.getPeopleByName("martine");
        assertThat(result.get(0).getName(),is("martine"));
    }


    private void givenPeople() {
        givenPerson("martine","A");
        givenPerson("david","B");
        givenPerson("jongil","O");
        givenBlockPerson("martine","AB");
    }

    private void givenPerson(String name, String bloodTypes) {
        personRepository.save(new Person(name,bloodTypes));
    }

    private void givenBlockPerson(String name, String bloodType){
        Person blockPerson = new Person(name,bloodType);

        personRepository.save(blockPerson);
    }

    @Test
    void getPerson(){
        givenPeople();

        Person person = personService.getPerson(3L);

        System.out.println(person);
    }

}