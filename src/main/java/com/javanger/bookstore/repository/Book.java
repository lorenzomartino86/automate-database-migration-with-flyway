package com.javanger.bookstore.repository;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private long editionYear;

    @OneToOne
    @JoinColumn(name="author_id")
    private Author author;




}
