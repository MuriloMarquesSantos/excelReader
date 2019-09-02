package com.example.testingApachePOI.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.testingApachePOI.entity.Person;

public class PersonRepository {

    private List<Person> people = new ArrayList<>();

    public Person savePerson(Person person) {
        people.add(person);

        return person;
    }
}
