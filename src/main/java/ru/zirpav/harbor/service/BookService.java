package ru.zirpav.harbor.service;

import ru.zirpav.harbor.model.Book;

import java.util.List;

public interface BookService {

    List<Book> allBooks();

    Book findByIdBook(int id);

    void deleteBook(int id);

    void saveBook(Book book);

    void editBook(Book book);

}
