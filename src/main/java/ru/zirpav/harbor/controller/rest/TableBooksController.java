package ru.zirpav.harbor.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.zirpav.harbor.model.TableBooks;
import ru.zirpav.harbor.service.TableBooksService;

@RestController
public class TableBooksController {

    private final TableBooksService tableBooksService;

    @Autowired
    public TableBooksController(TableBooksService tableBooksService) {
        this.tableBooksService = tableBooksService;
    }

    @GetMapping("/tableBooks")
    private TableBooks tableBooks(@RequestBody TableBooks tableBooks){
        return tableBooksService.findByIdTableBooks(tableBooks.getId());
    }
}
