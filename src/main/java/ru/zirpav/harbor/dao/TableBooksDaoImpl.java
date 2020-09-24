package ru.zirpav.harbor.dao;

import org.springframework.stereotype.Repository;
import ru.zirpav.harbor.model.TableBooks;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TableBooksDaoImpl implements TableBooksDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public TableBooks findByIdTableBooks(int id) {
        return entityManager.find(TableBooks.class, id);
    }

}
