package com.fynes.greve.repository;

import com.fynes.greve.model.Person;

import java.util.List;

public interface PeopleRepository {

    List<Person> list();
    Person get(String id);
    void save(Person person);
}
