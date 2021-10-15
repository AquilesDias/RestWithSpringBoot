package br.com.development.spring.restwithspringboot.services;

import br.com.development.spring.restwithspringboot.DTO.PersonDto;
import br.com.development.spring.restwithspringboot.converter.DozerConverter;
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

    public PersonDto create(PersonDto person){
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(personRepository.save(entity), PersonDto.class);
        return vo;
    }

    public PersonDto findById(Long id){
        var entity =  personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " +id));
        return DozerConverter.parseObject(entity, PersonDto.class);
    }

    public List<PersonDto> findByAll(){
        return DozerConverter.parseObject(personRepository.findAll(), PersonDto.class);
    }

    public PersonDto update(PersonDto person){

        var entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: "));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return DozerConverter.parseObject(personRepository.save(entity), PersonDto.class);

    }

    public void delete(Long id){
        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " +id));

        personRepository.delete(entity);
    }
}

