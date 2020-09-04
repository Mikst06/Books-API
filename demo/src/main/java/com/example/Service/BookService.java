package com.example.Service;

import com.example.Model.Book;
import com.example.Repository.BookRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    public void editBook(Book book) {
        if(bookRepository.findByISBN(book.getISBN()) != null) {
            bookRepository.save(book);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public boolean ISBN_validator_check(Book book) {
        String ISBN = book.getISBN();
        int n = ISBN.length();

        if (n != 10)
            return false;

        int sum = 0;
        for (int i = 0; i < 9; i++)
        {
            int digit = ISBN.charAt(i) - '0';
            if (0 > digit || 9 < digit)
                return false;
            sum += (digit * (10 - i));
        }

        char last = ISBN.charAt(9);
        if (last != 'X' && (last < '0' ||
                            last > '9'))
            return false;

        sum += ((last == 'X') ? 10 : (last - '0'));

        return (sum % 11 == 0);
    }

}
