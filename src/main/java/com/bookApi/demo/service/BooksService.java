package com.bookApi.demo.service;

import com.bookApi.demo.Exceptions.BookNotFoundException;
import com.bookApi.demo.model.Books;
import com.bookApi.demo.repository.BooksRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    //Create Book
    public Books saveAll (Books books){
        try {
            return booksRepository.saveAndFlush(books);
        }
        catch (Exception e){
            throw new RuntimeException("Erro ao inserir o livro no banco de dados...");
        }
    }

    //Get All Books
    public List<Books> getAll(){
        try {
            return booksRepository.findAll();
        }
        catch (Exception e){
            throw  new RuntimeException("Erro ao buscar livros...");
        }
    }

    //Find by id
    public Books findById(Long id){
        try {
            return booksRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Livro não encontrado com o id " + id));
        }
        catch (Exception e){
            throw new  BookNotFoundException("Livro não encontrado com o id " + id);
        }
    }

    //Find Book by Name
    public Books findByAuthor(String name){
        try {
            return booksRepository.findByAuthor(name).orElseThrow(()-> new  BookNotFoundException("Livro não encontrado com o nome " + name));
        }
        catch (Exception e){
            throw  new  BookNotFoundException("Livro não encontrado com o nome " + name);
        }
    }

    //Update
    public Books update(Long id, Books booksUpdate) {
        try {
            Books booksId = findById(id);
            booksId.setAuthor(booksUpdate.getAuthor());
            booksId.setTitle(booksUpdate.getTitle());
            booksId.setGender(booksUpdate.getGender());
            booksId.setDate(booksUpdate.getDate());
            return booksRepository.saveAndFlush(booksId);
        } catch (Exception e) {
            throw new BookNotFoundException("Livro não encontrado com o id " + id);
        }
    }

        //Delete
        @Transactional
        public void delete(Long id){
            try {
                Books find_id = findById(id);
                if (find_id != null) {
                    booksRepository.deleteById(id);
                }
                else {
                    throw new  BookNotFoundException("Livro não encontrado com o id " + id);
                }
            }
            catch (Exception e){
                throw new RuntimeException("Erro ao deletar...");
            }
        }
    }


