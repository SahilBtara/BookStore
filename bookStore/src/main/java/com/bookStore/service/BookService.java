package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Book;
import com.bookStore.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bRepo;
	
	public void save(Book b) {
		bRepo.save(b);
	}
	
	public List<Book> getAllBook(){
		return bRepo.findAll();
	}
	
	public Book getBookById(int id) {
		return bRepo.findById(id).get();
	}

	public List<Book> getBooksByName(String name) {
		return bRepo.findByNameContaining(name);
	}

	public List<Book> getBooksByNameOrAuthor(String name) {
		List<Book> b1 = bRepo.findByNameContaining(name);
		List<Book> b2 = bRepo.findByAuthorContaining(name);
		b1.addAll(b2);
		return b1;
	}

	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
}
