package br.com.development.spring.restwithspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.development.spring.restwithspringboot.model.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, Long>{

}
