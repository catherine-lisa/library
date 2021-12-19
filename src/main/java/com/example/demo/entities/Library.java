package com.example.demo.entities;

public class Library {
    private String bookname = null;
    private String author = null;
    private String publisher = null;
    private String publishDate = null;
    private String leftNumber = null;
    public String fileName = "127.0.0.1:8080/book4.jpg";

    public String getBookname() {
        return bookname;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getPublishDate() {
        return publishDate;
    }
    public String getLeftNumber() {
        return leftNumber;
    }

    public void setBookname(String content) {this.bookname = content;}
    public void setAuthor(String content) {this.author = content;}
    public void setPublisher(String content) {this.publisher = content;}
    public void setPublishDate(String content) {this.publishDate = content;}
    public void setLeftNumber(String content) {this.leftNumber = content;}
}
