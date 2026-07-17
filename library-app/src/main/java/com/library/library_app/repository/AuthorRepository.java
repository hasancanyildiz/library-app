package com.library.library_app.repository;

import com.library.library_app.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    // Spring Data JPA bu metodun ismine bakıp SQL sorgusunu kendi yazar! (SELECT * FROM author WHERE name = ?)
    Optional<Author> findByName(String name);
}