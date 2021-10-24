package br.com.development.spring.restwithspringboot.controller;

import br.com.development.spring.restwithspringboot.DTO.BookDto;
import br.com.development.spring.restwithspringboot.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Api(tags = "Book Endpoint")
@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;


	// *** METHODS POST

	@PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
				 consumes = {"application/json", "application/xml", "application/x-yaml"})
	public BookDto create(@RequestBody BookDto book){
		BookDto bookDto = bookService.create(book);
		book.add(linkTo(methodOn(BookController.class).findById(book.getKey())).withSelfRel());
		return book;
	}

	// *** METHODS GET

	@ApiOperation(value = "Find all people records")
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml" })
	public List<BookDto> findByAll(){
		
		List<BookDto> book = bookService.findByAll();
		
			book
	        .stream()
	        .forEach(b-> b.add(
	        			linkTo(methodOn(BookController.class).findById(b.getKey())).withSelfRel()));
		return book;
	}
	
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml" })
	public BookDto findById(@PathVariable("id") Long id) {
		BookDto bookDto = bookService.findById(id);
		bookDto.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return bookDto;
	}

	// *** METHODS UPDATE
	@PutMapping
	public BookDto update(@RequestBody BookDto bookDto){
		BookDto bookDto1 = bookService.update(bookDto);
		bookDto.add(linkTo(methodOn(BookController.class).findById(bookDto1.getKey())).withSelfRel());
		return bookDto;
	}

	// *** METHODS DELETE
	@DeleteMapping("/{id}")
	ResponseEntity<?> delete(@PathVariable("id") Long id){
		bookService.delete(id);
		return ResponseEntity.ok().build();
	}

}
