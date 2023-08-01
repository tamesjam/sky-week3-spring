package com.sky.Week3Spring.rest;

import com.sky.Week3Spring.domain.Person;
import com.sky.Week3Spring.services.SpringService;
import com.sky.Week3Spring.services.SpringServiceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/person")
public class SpringController {

    private SpringServiceList service;

    public SpringController() {
    }

    @PostMapping("/createPerson")
    public HttpEntity<Person> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(service.createPerson(person), HttpStatus.CREATED);
    }

    @PostMapping("/createPeople")
    public HttpEntity<List<Person>> createPeople(@RequestBody List<Person> people) {
        return new ResponseEntity<>(service.createPeople(people), HttpStatus.CREATED);
    }

    @GetMapping("/getPeople")
    public HttpEntity<List<Person>> getPeople() {
        return new ResponseEntity<>(this.service.getPeople(), HttpStatus.OK);
    }

    @GetMapping("/getPerson/{id}") // Specific Person with ID given by its unique index
    public HttpEntity<Person> getPerson(@PathVariable Integer id) {
        return new ResponseEntity<>(this.service.getPerson(id), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public HttpEntity<Person> update(@PathVariable Integer id,
                                     @RequestParam String firstName,
                                     @RequestParam String lastName,
                                     @RequestParam (value = "age", required = true) Integer age) {
        return new ResponseEntity<>(this.service.update(id, firstName, lastName, age), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<Boolean> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(this.service.delete(id), HttpStatus.OK);
    }
}
