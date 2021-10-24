package br.com.development.spring.restwithspringboot.controller;

import br.com.development.spring.restwithspringboot.DTO.PersonDto;
import br.com.development.spring.restwithspringboot.DTOV2.PersonDtoV2;
import br.com.development.spring.restwithspringboot.services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Api(tags = "Person Endpoint")
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonServices personServices;

    @PostMapping
    public PersonDto create(@RequestBody PersonDto personDto){

        PersonDto person = personServices.create(personDto);
        personDto.add(linkTo(methodOn(PersonController.class).findById(person.getKey())).withSelfRel());
        return personDto;
    }

    @PostMapping("/v2")
    public PersonDtoV2 person(@RequestBody PersonDtoV2 personDto){
        return personServices.createV2(personDto);
    }

    @ApiOperation(value = "Find all people records")
    @GetMapping
    public List<PersonDto> findByAll(){

        List<PersonDto> person = personServices.findByAll();

        person
                .stream()
                .forEach( p -> p.add(
                                linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
        return person;
    }

    @GetMapping("/{id}")
    public PersonDto findById(@PathVariable("id") Long id){
        PersonDto personDto = personServices.findById(id);
        personDto.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return personDto;
    }

    @PutMapping
    public PersonDto update(@RequestBody PersonDto personDto){
        PersonDto person = personServices.update(personDto);
        personDto.add(linkTo(methodOn(PersonController.class).findById(person.getKey())).withSelfRel());
        return personDto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok().build();
    }
}
