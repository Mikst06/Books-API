package com.example.Service;

import com.example.Model.Book;
import com.example.Repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){ this.bookRepository = bookRepository; }

    public void bookSave(Book book) {
        bookRepository.save(book);
    }

    public void bookDelete(Book book) {
        bookRepository.deleteByISBN(book.getISBN());
    }

    public Iterable<Book> bookShowAll() {
        return bookRepository.findAll();
    }
}
