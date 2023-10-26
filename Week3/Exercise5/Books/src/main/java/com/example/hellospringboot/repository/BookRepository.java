package com.example.hellospringboot.repository;
import com.example.hellospringboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    // Custom query to find books by author
    List<Book> findByAuthor(String author);

    // Custom query to find books by year
    List<Book> findByYear(int year);
}
