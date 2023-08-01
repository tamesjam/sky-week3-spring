package com.sky.Week3Spring.services;

import com.sky.Week3Spring.domain.Person;
import com.sky.Week3Spring.services.SpringService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Service
public class SpringServiceList implements SpringService {

    private List<Person> persons = new ArrayList<>();

    @Override
    public Person createPerson(@RequestBody Person person) {
        persons.add(person);
        return this.persons.get(this.persons.size() - 1);
    }

    @Override
    public List<Person> createPeople(@RequestBody List<Person> persons) {
        this.persons.addAll(persons);
        return this.persons.subList(this.persons.size() - persons.size(), this.persons.size());
    }

    @Override
    public List<Person> getPeople() {
        return this.persons;
    }

    @Override
    public Person getPerson(@PathVariable Integer id) {
        return this.persons.get(id);
    }

    @Override
    public Person update(@PathVariable Integer id,
                                     @RequestParam String firstName,
                                     @RequestParam String lastName,
                                     @RequestParam (value = "age", required = true) Integer age) {
        if(this.persons.get(id) != null) {
            Person p = this.persons.get(id);
            if(firstName != null) p.setFirstName(firstName);
            if(lastName != null) p.setLastName(lastName);
            if(age != null) p.setAge(age);
            return p;
        }

        return null;
    }

    @Override
    public boolean delete(@PathVariable Integer id) {
        if(this.persons.get(id) != null) {
            return this.persons.remove(id);
        }

        return false;
    }
}
