package org.cb.graphql.entity;

import java.util.List;

public record Book(
        Integer id,
        String name,
        Integer pageCount) {

    public static List<Book> books =
            List.of(
                    new Book(1, "Bhagwat Gita", 2000),
                    new Book(2, "Bhagwat Maha Puran", 16000),
                    new Book(3, "Java", 400),
                    new Book(4, "Spring Boot", 800)
            );

}
