package com.example.demo.Service;

import com.example.Controller.MainController;
import com.example.Model.Book;
import com.example.Repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.transaction.Transactional;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MainControllerTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private MainController controller;

    @Test
    public void whenDeleteByIdFromRepository_thenDeletingShouldBeSuccessful() {

        controller.addNewBook("r", "r", "123", 1, 1);
        controller.addNewBook("r", "r", "111", 1, 1);

        repository.deleteByISBN(eq("123"));
        assertThat(repository.count()).isEqualTo(1);
    }
}
