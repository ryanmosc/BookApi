package com.bookApi.demo.repository;

import com.bookApi.demo.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BooksRepository  extends JpaRepository<Books, Long> {
    Optional<Books> findByAuthor(String author);
}
