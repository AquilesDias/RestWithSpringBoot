package br.com.development.spring.restwithspringboot.converter.custom;

import br.com.development.spring.restwithspringboot.DTOV2.PersonDtoV2;
import br.com.development.spring.restwithspringboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonConverter {

    public PersonDtoV2 converterEntityToDtoV2(Person person){

        PersonDtoV2 personDtoV2 = new PersonDtoV2();

        personDtoV2.setId(person.getId());
        personDtoV2.setFirstName(person.getFirstName());
        personDtoV2.setLastName(person.getLastName());
        personDtoV2.setAddress(person.getAddress());
        personDtoV2.setGender(person.getGender());
        personDtoV2.setBirthDay(new Date());

        return personDtoV2;
    }

    public Person converterDtoV2ToEntity(PersonDtoV2 personDtoV2){
        Person person = new Person();

        person.setId(personDtoV2.getId());
        person.setFirstName(personDtoV2.getFirstName());
        person.setLastName(personDtoV2.getLastName());
        person.setAddress(person.getAddress());
        person.setGender(personDtoV2.getGender());

        return person;

    }
}
