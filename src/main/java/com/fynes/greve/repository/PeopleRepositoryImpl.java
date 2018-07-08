package com.fynes.greve.repository;

import com.fynes.greve.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


// TODO : make this actually use a database
public class PeopleRepositoryImpl implements PeopleRepository {

    List<Person> dummyData;

    public PeopleRepositoryImpl() {
        dummyData = new ArrayList<>();
        dummyData.add(new Person("1","jim", "jim@example.com"));
        dummyData.add(new Person("2","dave", "dave@example.com"));
        dummyData.add(new Person("3","frank", "frank@example.com"));

    }

    @Override
    public List<Person> list() {
        return dummyData;
    }

    @Override
    public Person get(String id) throws NoSuchElementException {
        Optional<Person> first = dummyData.stream().filter(p -> p.getId() == id).findFirst();

        if(first.isPresent()){
            return first.get();
        }
        else {
            throw new RuntimeException(String.format("No person found with id {}", id));
        }
    }

    @Override
    public void save(Person person) {
        dummyData.add(person);
    }
}
