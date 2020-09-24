package ru.zirpav.harbor.dao;

import ru.zirpav.harbor.model.Book;
import ru.zirpav.harbor.model.User;

import java.util.List;

public interface BookDao {

    List<Book> allBooks();

    Book findByIdBook(int id);

    void deleteBook(int id);

    void saveBook(Book book);

    void editBook(Book book);

    Book findBookForName(String name);
}
