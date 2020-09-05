package com.example.demo.Service;
import com.example.Model.Book;
import com.example.Repository.BookRepository;
import com.example.Service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

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
                .buildISBN("12345678999")
                .build();

        book3 = new Book.Builder("title3")
                .buildAuthor("author3")
                .buildNumber_of_pages(998)
                .buildRating(5)
                .buildISBN("123456789A")
                .build();

    }

    @Test
    public void When_findByISBN_is_null_then_throw_IllegalArgumentException() {
        when(bookRepository.findByISBN(book1.getISBN()))
                .thenReturn(null);

        Assertions.assertThrows(IllegalArgumentException.class, () -> bookService.editBook(book1));
    }

    @Test
    public void When_ISBN_validator_check_wrong_input_expect_false() {
        assertThat(bookService.ISBN_validator_check(book1)).isFalse();
        assertThat(bookService.ISBN_validator_check(book2)).isFalse();
        assertThat(bookService.ISBN_validator_check(book3)).isFalse();
    }
}
