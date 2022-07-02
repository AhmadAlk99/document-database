package com.books.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.books.model.Books;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	private static List<Books> books = new ArrayList<Books>();
	private static int todoCount = 3;

	static {
		books.add(new Books(1,  "Java", new Date(), "programing book"));
		books.add(new Books(2,  "c++", new Date(),"programing book" ));
		books.add(new Books(3, "c#", new Date(),
				"programing book"));
	}

	public List<Books> retrieveBooks() {
		List<Books> filteredBooks = new ArrayList<Books>();
		for (Books books : BookService.books) {
				filteredBooks.add(books);
		}
		return filteredBooks;
	}

	public void addBook(String getBookName, Date date, String description) {
		books.add(new Books(++todoCount, getBookName, date, description));
	}

	public void deleteBook(int id) {
		Iterator<Books> iterator = books.iterator();
		while (iterator.hasNext()) {
			Books books = iterator.next();
			if (books.getId() == id) {
				iterator.remove();
			}
		}
	}
}