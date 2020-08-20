package com.example.Controller;

import com.example.Model.Book;
import com.example.Service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;

@Controller
@RequestMapping(path="/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) { this.bookService = bookService; }

    @PostMapping(path="/add")
    public @ResponseBody String addNewBook (@RequestParam Book book) {
        bookService.bookSave(book);

        return "Saved\n";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllBooks() {
        return bookService.bookShowAll();
    }

    @PostMapping(path="/delete")
    @Transactional
    public @ResponseBody String deleteBook (@RequestParam Book book) {
        bookService.bookDelete(book);

        return "Deleted\n";
    }

}
