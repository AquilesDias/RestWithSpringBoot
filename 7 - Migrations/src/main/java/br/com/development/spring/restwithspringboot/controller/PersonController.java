package br.com.development.spring.restwithspringboot.controller;

import br.com.development.spring.restwithspringboot.DTO.PersonDto;
import br.com.development.spring.restwithspringboot.DTOV2.PersonDtoV2;
import br.com.development.spring.restwithspringboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonServices personServices;

    @PostMapping(produces = {"application/json", "application/xml"},
                 consumes = {"application/json", "application/xml"})
    public PersonDto person(@RequestBody PersonDto personDto){
        return personServices.create(personDto);
    }

    @PostMapping("/v2")
    public PersonDtoV2 person(@RequestBody PersonDtoV2 personDto){
        return personServices.createV2(personDto);
    }

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<PersonDto> findByAll(){
        return personServices.findByAll();
    }

    @GetMapping(value = "/{id}", produces = {"application/xml", "application/json"})
    public PersonDto findById(@PathVariable("id") Long id){
        return personServices.findById(id);
    }

    @PutMapping(produces = {"application/json", "application/xml"},
                consumes = {"application/json","appliction/xml"})
    public PersonDto update(@RequestBody PersonDto personDto){
        return personServices.update(personDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok().build();
    }
}