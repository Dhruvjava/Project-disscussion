package org.cb.graphql.rest;

import org.cb.graphql.entity.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookRest {

    @QueryMapping
    public List<Book> books() {
        return Book.books;
    }

    @QueryMapping
    public Book bookById(@Argument Integer id) {
        return Book.books.stream().filter(book -> book.id().equals(id)).findFirst().orElse(null);
    }

}
