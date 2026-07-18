package com.library.library_app.controller;

import com.library.library_app.model.Author;
import com.library.library_app.repository.AuthorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;
    public AuthorController (AuthorRepository authorRepository){
        this.authorRepository=authorRepository;
    }
    @GetMapping
    public List<Author> getAllAuthor(){return authorRepository.findAll();
    }
    @PostMapping
    public Author addAuthor (@RequestBody Author author){
        return authorRepository.save(author);
    }


}
