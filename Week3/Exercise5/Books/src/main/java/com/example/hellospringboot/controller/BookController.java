package com.example.hellospringboot.controller;

import com.example.hellospringboot.model.Book;
import com.example.hellospringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
//@RequestMapping("/api/books")
public class BookController {
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        updatedBook.setId(id);
        bookRepository.save(updatedBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
    @GetMapping("/author/{authorName}")
    public List<Book> getBooksByAuthor(@PathVariable String authorName) {
        return bookRepository.findByAuthor(authorName);
    }

    @GetMapping("/year/{publicationYear}")
    public List<Book> getBooksByYear(@PathVariable int publicationYear) {
        return bookRepository.findByYear(publicationYear);
    }
/*
    private List<Book> books = new ArrayList<>();
    private Long nextId = 1L;
    public BookController() {
        books.add(new Book(nextId++, "To Kill a Mockingbird", "Harper Lee", 1960));
        books.add(new Book(nextId++, "1984", "George Orwell", 1949));
        books.add(new Book(nextId++, "The Great Gatsby", "F. Scott Fitzgerald", 1925));
        books.add(new Book(nextId++, "The Catcher in the Rye", "J.D. Salinger", 1951));
        books.add(new Book(nextId++, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997));
        books.add(new Book(nextId++, "The Da Vinci Code", "Dan Brown", 2003));
    }
    // Get a list of all books
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // Get a specific book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        Optional<Book> foundBook = books.stream().filter(book -> book.getId().equals(id)).findFirst();
        return foundBook.orElse(null);
    }

    // Add a new book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        book.setId(nextId);
        nextId++;
        books.add(book);
        return book;
    }

    // Update an existing book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Optional<Book> foundBook = books.stream().filter(book -> book.getId().equals(id)).findFirst();
        if (foundBook.isPresent()) {
            Book book = foundBook.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setYear(updatedBook.getYear());
            return book;
        }
        return null;
    }

    // Delete a book by ID
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

 */
}
