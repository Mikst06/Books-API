package com.example.demo.Service;

import com.example.Controller.BookController;
import com.example.Model.Book;
import com.example.Service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController controller;

    private final ArgumentCaptor<Book> argumentCaptor = ArgumentCaptor.forClass(Book.class);

    private final Book book1 = new Book();
    private final List<String> bookParameterList = new ArrayList<>();

    @BeforeEach
    void init() {
        book1.setTitle("title");
        book1.setAuthor("author");
        book1.setNumber_of_pages(997);
        book1.setRating(4);
        book1.setISBN("12321");

        bookParameterList.addAll(book1.bookToList());
    }

    @Test
    public void When_addNewBook_expect_bookService_called() {
        controller.addNewBook(book1);
        verify(bookService).bookSave(argumentCaptor.capture());
        Assertions.assertEquals(bookParameterList, argumentCaptor.getValue().bookToList());
    }

    @Test
    public void When_getAllBooks_expect_bookService_called() {
        controller.getAllBooks();
        verify(bookService).bookShowAll();
    }

    @Test
    public void When_deleteBook_expect_bookService_called() {
        controller.deleteBook(book1);
        verify(bookService).bookDelete(argumentCaptor.capture());
        Assertions.assertEquals(bookParameterList, argumentCaptor.getValue().bookToList());
    }
}
