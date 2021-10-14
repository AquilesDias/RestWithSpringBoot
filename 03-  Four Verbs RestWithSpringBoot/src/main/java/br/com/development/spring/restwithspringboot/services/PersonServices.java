package br.com.development.spring.restwithspringboot.services;

import br.com.development.spring.restwithspringboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    AtomicLong atomicLong = new AtomicLong();

    public Person create(Person person){
        return person;
    }

    public Person findById(String id){

        Person person = new Person();

        person.setId(atomicLong.incrementAndGet());
        person.setFirstName("Naruto");
        person.setLastName("Uzumaki");
        person.setAddress("Vila da Folha");
        person.setGender("Male");

        return person;
    }

    public List<Person> findByAll(){
        List<Person> personList = new ArrayList<>();

        for ( int i = 0; i < 5; i++ ){
            Person person = mockPerson(i);
            personList.add(person);
        }

        return personList;
    }

    private Person mockPerson(int i){
        Person person = new Person();

        person.setId(atomicLong.incrementAndGet());
        person.setFirstName("Person name" +i);
        person.setLastName("LastName" +i);
        person.setAddress("Address" +i);
        person.setGender("Gender" +i);

        return person;
    }

    public Person update(Person person){
        return person;
    }

    public void delete(String id){
    }
}
