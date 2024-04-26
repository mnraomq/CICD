package edu.tus.wizworld.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.tus.wizworld.dao.BookRepository;
import edu.tus.wizworld.dto.Book;
import edu.tus.wizworld.dto.Rating;
import edu.tus.wizworld.errors.BookValidator;
import edu.tus.wizworld.errors.ErrorMessage;
import edu.tus.wizworld.errors.ErrorMessages;
import edu.tus.wizworld.exceptions.BookException;

@RestController
@Service
@RequestMapping("/books")
public class BookStoreController {

	@Autowired
	BookRepository bookRepo;

	@Autowired
	BookValidator bookValidator;

	@GetMapping
	public List<Book> getBooks() {
		return bookRepo.findAll();
	}

	@RequestMapping("/{id}")
	public
	ResponseEntity getBookById(@PathVariable("id") Long id) {
		Optional<Book> book = bookRepo.findById(id);
		if (book.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(book);
		} else {
			ErrorMessage errorMessage = new ErrorMessage(ErrorMessages.BOOK_NOT_FOUND.toString());
			return ResponseEntity.status(HttpStatus.OK).body(errorMessage);
		}
	}

	@RequestMapping("/rating/{rating}")
	public
	List<Book> getBookByRating(@PathVariable("rating") Rating rating) {
		List<Book> booksByRating = new ArrayList<>();
		booksByRating = bookRepo.findByRating(rating);
		return booksByRating;
	}

	@RequestMapping("/prices/{min}/{max}")
	public
	List<Book> getBookByPricesBetween(@PathVariable("min") Double min, @PathVariable("max") Double max) {
		List<Book> booksByPrice = new ArrayList<>();
		booksByPrice = bookRepo.findByOnlinePriceBetween(min, max);
		return booksByPrice;
	}
	

	@PostMapping
	public ResponseEntity addBook(@RequestBody Book book) {
		try {
			bookValidator.validateBook(book);
			Book savedBook=bookRepo.save(book);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
		}
		catch(BookException e) {
			System.out.println(e.getMessage());
			ErrorMessage errorMessage=new ErrorMessage(e.getMessage());
			return ResponseEntity.badRequest().body(errorMessage);
		}
		
	}
}
