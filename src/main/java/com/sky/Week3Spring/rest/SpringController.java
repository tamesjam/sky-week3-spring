package com.sky.Week3Spring.rest;

import com.sky.Week3Spring.Person;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class SpringController {

    private List<Person> persons = new ArrayList<>();

    public SpringController() {
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("/createPerson")
    public HttpEntity<Person> createPerson(@RequestBody Person person) {
        System.out.println("Received a Person object: " + person);
        persons.add(person);
        Person created = this.persons.get(this.persons.size() - 1);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PostMapping("/createPeople")
    public HttpEntity<List<Person>> createPeople(@RequestBody List<Person> persons) {
        System.out.println("Received a list of Persons objects: " + persons);
        this.persons.addAll(persons);
        List<Person> created = new ArrayList<>();

        for (int i = 0; i < persons.size(); i++) {
            created.add(this.persons.get(i));
        }

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/getPeople")
    public HttpEntity<List<Person>> getPeople() {
        System.out.println("Getting multiple Persons object: ");
        return new ResponseEntity<>(this.persons, HttpStatus.OK);
    }

    @GetMapping("/getPerson/{id}") // Specific Person with ID given by its unique index
    public HttpEntity<Person> getPerson(@PathVariable Integer id) {
        System.out.println("Getting singular Person object: ");
        Person person = this.persons.get(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
