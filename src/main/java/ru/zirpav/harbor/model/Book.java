package ru.zirpav.harbor.model;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Scope
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private String genre;

    @Column
    private StatusBook statusBook;

    @Transient
    @ManyToMany(mappedBy = "books")
    private Set<TableBooks> tableBooksSet;

    public Book() {
    }

    public Book(String name, String author, String genre, StatusBook statusBook, Set<TableBooks> tableBooksSet) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.statusBook = statusBook;
        this.tableBooksSet = tableBooksSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public StatusBook getStatusBook() {
        return statusBook;
    }

    public void setStatusBook(StatusBook statusBook) {
        this.statusBook = statusBook;
    }

    public Set<TableBooks> getTableBooksSet() {
        return tableBooksSet;
    }

    public void setTableBooksSet(Set<TableBooks> tableBooksSet) {
        this.tableBooksSet = tableBooksSet;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
