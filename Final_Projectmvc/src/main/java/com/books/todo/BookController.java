package com.books.todo;

import java.util.Date;

import javax.validation.Valid;

import com.books.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.books.todo.service.BookService;

@Controller
@SessionAttributes("name")
public class BookController {

	@Autowired
	private BookService service;

	@RequestMapping(value = "/list-books", method = RequestMethod.GET)
	public String showBooksList(ModelMap model) {
		String user = (String) model.get("name");
		model.addAttribute("books", service.retrieveBooks());
		return "list-books";
	}

	@RequestMapping(value = "/add-book", method = RequestMethod.GET)
	public String showAddBooksPage(ModelMap model) {
		model.addAttribute("book", new Books());
		return "book";
	}

	@RequestMapping(value = "/add-book", method = RequestMethod.POST)
	public String addBook(ModelMap model, @Valid Books books, BindingResult result) {

		if (result.hasErrors())
			return "book";

		service.addBook(books.getBookName(), new Date(), books.getDescription());
		model.clear();// to prevent request parameter "name" to be passed
		return "welcome";
	}

	@RequestMapping(value = "/delete-book", method = RequestMethod.GET)
	public String deleteBook(@RequestParam int id) {
		service.deleteBook(id);
		return "welcome";
	}

}