package ru.zirpav.harbor.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class TableBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToOne(mappedBy = "tableBooks")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Book> books;

    public TableBooks() {

    }

    public TableBooks(User user, Set<Book> books) {
        this.user = user;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
