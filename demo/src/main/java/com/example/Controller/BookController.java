package com.example.Controller;

import com.example.Model.Book;
import com.example.Service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
@RequestMapping(path="/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) { this.bookService = bookService; }

    @PostMapping(path="/add")
    public @ResponseBody String addNewBook (@RequestBody Book book) {
        bookService.bookSave(book);

        return "Saved\n";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllBooks() {
        return bookService.bookShowAll();
    }

    @DeleteMapping(path="/delete")
    @Transactional
    public @ResponseBody String deleteBook (@RequestBody Book book) {
        bookService.bookDelete(book);

        return "Deleted\n";
    }

}
