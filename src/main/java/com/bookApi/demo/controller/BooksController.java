package com.bookApi.demo.controller;

import com.bookApi.demo.model.Books;
import com.bookApi.demo.service.BooksService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    //Create Book
    @Operation(description = "Create Book")
    @PostMapping
    public Books saveAll(@RequestBody @Valid Books books){
        return booksService.saveAll(books);
    }

    //Get All Books
    @Operation(description = "Get all Books")
    @GetMapping
    public List<Books> getAll(){
        return booksService.getAll();
    }

    //Find Book by id
    @Operation(description = "Find Book for id")
    @GetMapping("/{id}")
    public ResponseEntity<Books> findById(@PathVariable Long id){
        Books books = booksService.findById(id);
        return ResponseEntity.ok(books);
    }

    //Find Book by name
    @Operation(description = "Find book for name")
   @GetMapping("/search")
    public ResponseEntity<Books> findByName(@RequestParam String author){
        Books books =booksService.findByAuthor(author);
        return ResponseEntity.ok(books);
    }

    //Update
    @Operation(description = "Update Book")
    @PutMapping("/{id}")
    public ResponseEntity<Books> update(@RequestBody @Valid Books body, @PathVariable Long id){
        Books books = booksService.update(id, body);
        return ResponseEntity.ok(books);
    }

    //Delete
    @Operation(description = "delete Book")
    @DeleteMapping("/{id}")
    public ResponseEntity<Books> delete(@PathVariable Long id){
        booksService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
