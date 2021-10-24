package br.com.development.spring.restwithspringboot.services;

import br.com.development.spring.restwithspringboot.DTO.BookDto;
import br.com.development.spring.restwithspringboot.converter.DozerConverter;
import br.com.development.spring.restwithspringboot.exception.ResourceNotFoundException;
import br.com.development.spring.restwithspringboot.model.Books;
import br.com.development.spring.restwithspringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;

	// METHODS GET

	public List<BookDto> findByAll(){
		return DozerConverter.parseObject(bookRepository.findAll(), BookDto.class);
	}

	public BookDto findById(Long id) {
		var entity = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: +id"));
		
		return DozerConverter.parseObject(entity, BookDto.class);
	}

	// METHODS POST

	public BookDto create(BookDto book) {
		var entity = DozerConverter.parseObject(book, Books.class);
		var vo = DozerConverter.parseObject(bookRepository.save(entity), BookDto.class);
		return vo;
	}

	// METHODS UPDATE
	public BookDto update(BookDto bookDto){
		var entity = bookRepository.findById(bookDto.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: +id"));

		entity.setAuthor(bookDto.getAuthor());
		entity.setLaunch_date(bookDto.getLaunch_date());
		entity.setPrice(bookDto.getPrice());
		entity.setTitle(bookDto.getTitle());

		return DozerConverter.parseObject(bookRepository.save(entity), BookDto.class);
	}


	// METHODS DELETE
	public void delete(Long id){
		Books entity = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: +id"));

		bookRepository.delete(entity);
	}

}
