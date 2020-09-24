package ru.zirpav.harbor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zirpav.harbor.dao.TableBooksDao;
import ru.zirpav.harbor.model.TableBooks;

@Service
@Transactional
public class TableBooksServiceImpl implements TableBooksService {

    private TableBooksDao tableBooksDao;

    @Autowired
    public TableBooksServiceImpl(TableBooksDao tableBooksDao) {
        this.tableBooksDao = tableBooksDao;
    }

    @Override
    public TableBooks findByIdTableBooks(int id) {
        return tableBooksDao.findByIdTableBooks(id);
    }
}
