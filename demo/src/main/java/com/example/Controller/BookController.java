package com.example.Controller;

import com.example.Model.Book;
import com.example.Service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(path="/books")
public class BookController {
    private static final Logger LOG = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    public BookController(BookService bookService) { this.bookService = bookService; }

    @PostMapping(path="/add")
    public @ResponseBody void addNewBook (@RequestBody Book book) {
        bookService.bookSave(book);

        LOG.info("Book with ISBN -> {} <- has been ADDED", book.getISBN());
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllBooks() {
        return bookService.bookShowAll();
    }

    @DeleteMapping(path="/delete")
    @Transactional
    public @ResponseBody void deleteBook (@RequestBody Book book) {
        bookService.bookDelete(book);

        LOG.info("Book with ISBN -> {} <- has been DELETED", book.getISBN());
    }

}
