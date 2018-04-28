package com.javanger.bookstore.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class BookRepositoryIT {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @After
    public void tearDown(){
        bookRepository.deleteAll();
        authorRepository.deleteAll();
    }

    @Test
    public void canCreateBook() throws Exception {
        Author dick = author("Philip K.", "Dick");
        Book ubik = book("Ubik", dick, 1969);

        authorRepository.save(dick);
        bookRepository.save(ubik);

        final List<Book> books = bookRepository.findAll();
        assertNotNull(books);
        assertThat(books.size(), is(1));
        final Book firstBook = books.get(0);
        assertThat(firstBook.getTitle(), is("Ubik"));
        assertThat(firstBook.getAuthor().getSurname(), is("Dick"));

    }

    public static Book book(String title, Author author, long editionYear) {
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setEditionYear(editionYear);
        return book;
    }

    public static Author author(String firstName, String surname) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setSurname(surname);
        return author;
    }
}