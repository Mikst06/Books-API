package com.example.Repository;

import com.example.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    long deleteByISBN(String ISBN);
}
