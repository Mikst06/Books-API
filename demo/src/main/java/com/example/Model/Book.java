package com.example.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;

@Entity
public class Book {


    @Id
    private String title;

    private String author;

    private Integer number_of_pages;

    private Integer rating;

    private String ISBN;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(Integer number_of_pages) {
        this.number_of_pages = number_of_pages;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<String> bookToList() {
        return Arrays.asList(getTitle(), getAuthor(), getNumber_of_pages().toString(), getRating().toString(), getISBN());
    }
}
