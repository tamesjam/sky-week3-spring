package com.sky.Week3Spring.services;
import com.sky.Week3Spring.domain.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface SpringService {
    Person createPerson(Person person);
    List<Person> createPeople(List<Person> people);
    Person getPerson(Integer id);
    List<Person> getPeople();
    Person update(Integer id, String firstName, String lastName, Integer age);
    boolean delete(Integer id);
}
