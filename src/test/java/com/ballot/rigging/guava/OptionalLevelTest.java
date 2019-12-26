package com.ballot.rigging.guava;

import com.ballot.rigging.pojo.Book;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * @Auther: wkd
 * @Date: 2019/12/26 18:00
 * @Description:
 */
public class OptionalLevelTest {

    @Test
    public void whenCheckIfPresent_thenOk() {
        Book book = new Book("john@gmail.com", 1234);
        Optional<Book> opt = Optional.ofNullable(book);
        assertTrue(opt.isPresent());

        assertEquals(book.getName(), opt.get().getName());

        opt.ifPresent( u -> assertEquals(book.getName(), u.getName()));
    }


    @Test
    public void whenEmptyValue_thenReturnDefault() {
        Book book = null;
        Book book2 = new Book("anna@gmail.com", 123);
        Book result = Optional.ofNullable(book).orElse(book2);

        assertEquals(book2.getName(), result.getName());
    }

    @Test
    public void whenValueNotNull_thenIgnoreDefault() {
        Book Book = new Book("john@gmail.com",1234);
        Book Book2 = new Book("anna@gmail.com", 1234);
        Book result = Optional.ofNullable(Book).orElse(Book2);

        assertEquals("john@gmail.com", result.getName());
    }
}
