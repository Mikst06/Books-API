package com.example.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {


    private String title;
    private String author;
    private Integer number_of_pages;
    private Integer rating;
    @Id
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

    @Override
    public String toString() {
        return "Book {" +
                "title=" + title + '\'' +
                "author" + author + '\'' +
                "number_of_pages" + number_of_pages + '\'' +
                "rating" + rating + '\'' +
                "ISBN" + ISBN + '}';
    }

    public static class Builder {

        private String title;
        private String author;
        private Integer number_of_pages;
        private Integer rating;
        private String ISBN;

        public Builder(String title) {
            this.title = title;
        }

        public Builder buildAuthor(String author){
            this.author = author;

            return this;
        }

        public Builder buildNumber_of_pages(Integer number_of_pages){
            this.number_of_pages = number_of_pages;

            return this;
        }

        public Builder buildRating(Integer rating){
            this.rating = rating;

            return this;
        }

        public Builder buildISBN(String ISBN){
            this.ISBN = ISBN;

            return this;
        }

        public Book build(){
            Book book = new Book();
            book.title = this.title;
            book.author = this.author;
            book.number_of_pages = this.number_of_pages;
            book.rating = this.rating;
            book.ISBN = this.ISBN;

            return book;
        }
    }
}
