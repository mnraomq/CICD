package edu.tus.wizworld.errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import edu.tus.wizworld.dao.BookRepository;
import edu.tus.wizworld.dto.Book;
import edu.tus.wizworld.exceptions.BookValidationException;

@Component
public class BookValidator {
	Book book;
	
	@Autowired
	BookRepository bookRepo;
	
	public void validateBook(Book book) throws BookValidationException {
		this.book = book;
		checkEmptyFields(book);
		checkIfTitleAlreadyExists(book);
		checkPricing(book);
	}
	

	private void checkEmptyFields(Book book) throws BookValidationException {
		if ((book.getTitle().length() == 0) || (book.getSeries().length() == 0)) {
			throw new BookValidationException(ErrorMessages.EMPTY_FIELDS.getMsg());
		}
	}
	private void checkIfTitleAlreadyExists(Book book) throws BookValidationException {
		
		//TO DO
		
		Book existingBook = bookRepo.findByTitle(book.getTitle());
		if (existingBook != null) {
			throw new BookValidationException(ErrorMessages.ALREADY_EXISTS.getMsg());
		}
	}

	private void checkPricing(Book book) throws BookValidationException {
		
		//TO DO
		
		if (book.getOnlinePrice() >= book.getRealRetailPrice()) {
			throw new BookValidationException((ErrorMessages.ONLINE_PRICE_HIGH.getMsg()));
		}
	}
}

