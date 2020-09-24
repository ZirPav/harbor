package ru.zirpav.harbor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zirpav.harbor.dao.BookDao;
import ru.zirpav.harbor.model.Book;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> allBooks() {
        return bookDao.allBooks();
    }

    @Override
    public Book findByIdBook(int id) {
        return bookDao.findByIdBook(id);
    }

    @Override
    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void saveBook(Book book) {
        Book bookDB = bookDao.findByIdBook(book.getId());
        if (bookDB != null) {
            return;
        }
        bookDao.saveBook(book);
    }

    @Override
    public void editBook(Book book) {
        bookDao.editBook(book);
    }
}
