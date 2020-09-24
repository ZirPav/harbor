package ru.zirpav.harbor.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zirpav.harbor.model.Book;
import ru.zirpav.harbor.service.BookService;
import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/newBook")
    public Book creatNewBook(){
        return new Book();
    }

    @GetMapping("/bookInfo")
    public List<Book> bookInfo(){
        return bookService.allBooks();
    }

    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/editBook")
    public ResponseEntity<?> editBook(@RequestBody Book book) {
        bookService.editBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<?> deleteBook(@RequestBody Book book) {
        bookService.deleteBook(book.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
