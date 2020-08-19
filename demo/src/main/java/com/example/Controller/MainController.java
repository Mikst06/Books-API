package com.example.Controller;

import com.example.Model.Book;
import com.example.Repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;

@Controller
@RequestMapping(path="/books")
public class MainController {

    private final BookRepository bookRepository;

    public MainController(BookRepository bookRepository) { this.bookRepository = bookRepository; }

    @PostMapping(path="/add")
    public @ResponseBody String addNewBook (@RequestParam String title, @RequestParam String author,
                                            @RequestParam String ISBN, @RequestParam Integer number_of_pages,@RequestParam Integer rating) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setISBN(ISBN);
        book.setNumber_of_pages(number_of_pages);
        book.setRating(rating);

        bookRepository.save(book);

        return "Saved\n";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping(path="/delete")
    @Transactional
    public @ResponseBody String deleteBook (@RequestParam String ISBN) {
        bookRepository.deleteByISBN(ISBN);

        return "Deleted\n";
    }

}
