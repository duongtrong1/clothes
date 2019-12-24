package com.smartosc.ecommerce.clothes.service;

import com.smartosc.ecommerce.clothes.model.Book;

import java.util.List;

public interface BookService {
	List<Book> findAll();
	
	Book findOne(Long id);
	
	List<Book> findByCategory(String category);
	
	List<Book> blurrySearch(String title);
}
