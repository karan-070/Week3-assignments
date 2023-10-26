package com.example.hellospringboot.component;
import com.example.hellospringboot.model.Book;
import com.example.hellospringboot.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final BookRepository bookRepository;

    public DataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    private Long nextId = 1L;
    @Override
    public void run(String... args) {
        bookRepository.save(new Book(nextId++,"To Kill a Mockingbird", "Harper Lee", 1960));
        bookRepository.save(new Book(nextId++,"1984", "George Orwell", 1949));
        bookRepository.save(new Book(nextId++,"The Great Gatsby", "F. Scott Fitzgerald", 1925));
        bookRepository.save(new Book(nextId++,"The Catcher in the Rye", "J.D. Salinger", 1951));
        bookRepository.save(new Book(nextId++,"Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997));
        bookRepository.save(new Book(nextId++,"The Da Vinci Code", "Dan Brown", 2003));
    }
}