package com.library.library_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonIgnore // Sonsuz döngüyü engellemek için çok kritik! (Aşağıda açıklayacağım)
    private List<Book> books = new ArrayList<>();

    // Boş Constructor (JPA için zorunlu)
    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    // Getter ve Setter'lar
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
}