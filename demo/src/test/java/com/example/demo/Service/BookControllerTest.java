package com.example.demo.Service;

import com.example.Controller.BookController;
import com.example.Model.Book;
import com.example.Service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController controller;

    private Book book1, book2, book3;

    @BeforeEach
    void init() {
        book1 = new Book.Builder("title1")
                .buildAuthor("author1")
                .buildNumber_of_pages(997)
                .buildRating(4)
                .buildISBN("12321")
                .build();

        book2 = new Book.Builder("title2")
                .buildAuthor("author2")
                .buildNumber_of_pages(998)
                .buildRating(5)
                .buildISBN("12322")
                .build();

    }

    @Test
    public void When_addNewBook_expect_bookService_called() {
        final ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);
        controller.addNewBook(book1);
        verify(bookService).bookSave(argumentCaptor.capture());
        Assertions.assertEquals("title", argumentCaptor.getValue().getTitle());
        Assertions.assertEquals("author", argumentCaptor.getValue().getAuthor());
        Assertions.assertEquals(997, argumentCaptor.getValue().getNumber_of_pages());
        Assertions.assertEquals(4, argumentCaptor.getValue().getRating());
        Assertions.assertEquals("12321", argumentCaptor.getValue().getISBN());
    }

    @Test
    public void When_getAllBooks_expect_bookService_called() {
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        when(bookService.bookShowAll()).thenReturn(books);
        List<Book> returnedBooks = (List<Book>) controller.getAllBooks();
        assertThat(returnedBooks.size()).isEqualTo(2);
    }

    @Test
    public void When_deleteBook_expect_bookService_called() {
        controller.deleteBook(book1);
        verify(bookService).bookDelete(book1);
    }

}
