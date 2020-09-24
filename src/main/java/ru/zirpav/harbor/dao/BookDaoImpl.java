package ru.zirpav.harbor.dao;

import org.springframework.stereotype.Repository;
import ru.zirpav.harbor.model.Book;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Book> allBooks() {
        List<Book> bookList = entityManager.createQuery("SELECT b FROM Book b").getResultList();
        return bookList;
    }

    @Override
    public Book findByIdBook(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public void deleteBook(int id) {
        Book book = entityManager.find(Book.class, id);
        if (book != null) {
            entityManager.remove(book);
        }
    }

    @Override
    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    public void editBook(Book book) {
        entityManager.merge(book);
    }

    @Override
    public Book findBookForName(String name) {
        Book book = null;
        try {
            Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.name=:name");
            query.setParameter("name", name);
            book = (Book) query.getSingleResult();
        } catch (Exception e) {
            System.err.println("Book not found.");
        }

        return book;
    }
}
