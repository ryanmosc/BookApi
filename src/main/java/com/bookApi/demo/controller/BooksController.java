package com.bookApi.demo.controller;

import com.bookApi.demo.model.Books;
import com.bookApi.demo.service.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    //Create Book
    @PostMapping
    public Books saveAll(@RequestBody Books books){
        return booksService.saveAll(books);
    }

    //Get All Books
    @GetMapping
    public List<Books> getAll(){
        return booksService.getAll();
    }

    //Find Book by id
    @GetMapping("/{id}")
    public ResponseEntity<Books> findById(@PathVariable Long id){
        Books books = booksService.findById(id);
        return ResponseEntity.ok(books);
    }

    //Find Book by name
   @GetMapping("/search")
    public ResponseEntity<Books> findByName(@RequestParam String author){
        Books books =booksService.findByAuthor(author);
        return ResponseEntity.ok(books);
    }

    //Update
    @PutMapping("/{id}")
    public  ResponseEntity<Books> update(@RequestBody Books body, @PathVariable Long id){
        booksService.update(id, body);
        return ResponseEntity.ok().build();
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Books> delete(@PathVariable Long id){
        booksService.delete(id);
        return ResponseEntity.ok().build();
    }

}
