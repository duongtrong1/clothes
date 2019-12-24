package com.smartosc.ecommerce.clothes.service;

import com.smartosc.ecommerce.clothes.model.Book;
import com.smartosc.ecommerce.clothes.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        List<Book> bookList = bookRepository.findAll ();
        List<Book> activeBookList = new ArrayList<> ();

        for (Book book : bookList) {
            if (book.isActive ()) {
                activeBookList.add (book);
            }
        }

        return activeBookList;
    }

    public Book findOne(Long id) {
        return bookRepository.findById (id).orElseThrow (null);
    }

    public List<Book> findByCategory(String category) {
        List<Book> bookList = bookRepository.findByCategory (category);

        List<Book> activeBookList = new ArrayList<> ();

        for (Book book : bookList) {
            if (book.isActive ()) {
                activeBookList.add (book);
            }
        }

        return activeBookList;
    }

    public List<Book> blurrySearch(String title) {
        List<Book> bookList = bookRepository.findByTitleContaining (title);
        List<Book> activeBookList = new ArrayList<> ();

        for (Book book : bookList) {
            if (book.isActive ()) {
                activeBookList.add (book);
            }
        }

        return activeBookList;
    }
}
