package com.example.demo.Service;

import com.example.Controller.BookController;
import com.example.Model.Book;
import com.example.Repository.BookRepository;
import com.example.Service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController controller;

    @Test
    public void whenGetAllBooks_ThenBookShowAllTriggered() {
        assertThat(controller.getAllBooks()).isEqualTo(bookService.bookShowAll());
     }
}
