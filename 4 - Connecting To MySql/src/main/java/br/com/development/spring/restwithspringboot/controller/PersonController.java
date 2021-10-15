package br.com.development.spring.restwithspringboot.controller;

import br.com.development.spring.restwithspringboot.model.Person;
import br.com.development.spring.restwithspringboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonServices personServices;

    @PostMapping
    public Person person(@RequestBody Person person){
        return personServices.create(person);
    }

    @GetMapping
    public List<Person> findByAll(){
        return personServices.findByAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Long id){
        return personServices.findById(id);
    }

    @PutMapping
    public Person update(@RequestBody Person person){
        return personServices.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        personServices.delete(id);
    }
}
