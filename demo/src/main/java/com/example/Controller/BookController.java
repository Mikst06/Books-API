package com.example.Controller;

import com.example.Exceptions.ClientInputException;
import com.example.Model.Book;
import com.example.Service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping(path="/books")
public class BookController {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(BookController.class);

    private final BookService bookService;

    public BookController(BookService bookService) { this.bookService = bookService; }

    @PostMapping(path="/add")
    public @ResponseBody void addNewBook (@RequestBody Book book) {
        try {
            if (bookService.ISBN_validator_check(book)) {
                bookService.bookSave(book);
                log.info("Book with ISBN -> {} <- has been ADDED", book.getISBN());
            } else {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e) {
            log.error("Invalid ISBN number --> {} <--\t Exception: " + e, book.getISBN());

            throw new ClientInputException("Invalid ISBN number", e);
        }
    }

    @PostMapping(path="/update")
    public @ResponseBody void updateBook (@RequestBody Book book) {
        try {
            bookService.editBook(book);
            log.info("Book with ISBN -> {} <- has been EDITED", book.getISBN());
        } catch (IllegalArgumentException e) {
            log.error("Exeption " + e + " has occurred");

            throw new ClientInputException("Gived book doesn't exist", e);
        }
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllBooks() {
        return bookService.bookShowAll();
    }

    @DeleteMapping(path="/delete")
    @Transactional
    public @ResponseBody void deleteBook (@RequestBody Book book) {
        try{
        bookService.bookDelete(book);
        log.info("Book with ISBN -> {} <- has been DELETED", book.getISBN());
        } catch (Exception e){
            log.error("Exeption " + e + " has occurred");
        }
    }

}
