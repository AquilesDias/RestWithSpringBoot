package br.com.development.spring.restwithspringboot.services;

import br.com.development.spring.restwithspringboot.exception.ResourceNotFoundException;
import br.com.development.spring.restwithspringboot.model.Person;
import br.com.development.spring.restwithspringboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {

    @Autowired
    PersonRepository personRepository;

    public Person create(Person person){
        return personRepository.save(person);
    }

    public Person findById(Long id){
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " +id));
    }

    public List<Person> findByAll(){
        return personRepository.findAll();
    }

    public Person update(Person person){

        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: "));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);

    }

    public void delete(Long id){
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " +id));

        personRepository.delete(entity);
    }
}

