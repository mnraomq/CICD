package edu.tus.hpbookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import edu.tus.wizworld.controllers.BookStoreController;
import edu.tus.wizworld.dao.BookRepository;
import edu.tus.wizworld.dto.Book;
import edu.tus.wizworld.dto.Rating;
import edu.tus.wizworld.errors.BookValidator;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HarryPotterBookstoreApplicationTests {

	@Mock
	private BookRepository bookRepo;

	@Mock
	private BookValidator bookValidator;

	@InjectMocks
	private BookStoreController bookStoreController;
	
	HarryPotterBookstoreApplicationTests(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testJenkins() {
		assertTrue(true);
	}
	
	@Test
	public void testJenkinsMock() {
		when(bookRepo.findAll()).thenReturn(null);
		assertNull(bookStoreController.getBooks());
	}

//	@Test
//	public void testGetBooks() {
//		List<Book> mockBooks = new ArrayList<>();
//		mockBooks.add(new Book((long)1,"Another Book Title", "Another Book Series", "Another Author", 20.00, 25.00, "","",Rating.CLASSIC));
//		mockBooks.add(new Book((long)1,"Another Book Title", "Another Book Series", "Another Author", 20.00, 25.00, "","",Rating.CLASSIC));
//
//		when(bookRepo.findAll()).thenReturn(mockBooks);
//
//		List<Book> response = bookStoreController.getBooks();
//
//		assertNotNull(response);
//		//assertEquals(HttpStatus.OK, response.getStatusCode());
//		//assertEquals(mockBooks, response.getBody());
//	}
//
//	@Test
//	public void testGetBookById_Found() {
//		Long bookId = 1L;
//		Book mockBook = new Book((long)1,"Another Book Title", "Another Book Series", "Another Author", 20.00, 25.00, "","",Rating.CLASSIC);
//
//		when(bookRepo.findById(bookId)).thenReturn(Optional.of(mockBook));
//
//		ResponseEntity response = bookStoreController.getBookById(bookId);
//
//		assertNotNull(response);
//		//assertEquals(HttpStatus.OK, response.getStatusCode());
//		//assertEquals(mockBook, ((ResponseEntity<Book>) response).getBody());
//	}
//
//	@Test
//	public void testGetBookById_NotFound() {
//		Long bookId = 1L;
//
//		when(bookRepo.findById(bookId)).thenReturn(Optional.empty());
//
//		ResponseEntity response = bookStoreController.getBookById(bookId);
//
//		assertNotNull(response);
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		//assertEquals(ErrorMessages.BOOK_NOT_FOUND.toString(), ((ErrorMessage) ((ResponseEntity) response).getBody()).getMessage());
//	}
//
//	@Test
//	public void testGetBookByRating() {
//		Rating rating = Rating.VERY_GOOD;
//		List<Book> mockBooks = new ArrayList<>();
//		mockBooks.add(new Book((long)1,"Another Book Title", "Another Book Series", "Another Author", 20.00, 25.00, "","",Rating.CLASSIC));
//
//		when(bookRepo.findByRating(rating)).thenReturn(mockBooks);
//
//		List<Book> response = bookStoreController.getBookByRating(rating);
//
//		assertNotNull(response);
//		//assertEquals(HttpStatus.OK, response.getStatusCode());
//		//assertEquals(mockBooks, response.getBody());
//	}
//
//	@Test
//	public void testGetBookByPricesBetween() {
//		Double minPrice = 10.00;
//		Double maxPrice = 20.00;
//		List<Book> mockBooks = new ArrayList<>();
//		mockBooks.add(new Book((long)1,"Another Book Title", "Another Book Series", "Another Author", 20.00, 25.00, "","",Rating.CLASSIC));
//
//		when(bookRepo.findByOnlinePriceBetween(minPrice, maxPrice)).thenReturn(mockBooks);
//
//		List<Book> response = bookStoreController.getBookByPricesBetween(minPrice, maxPrice);
//
//		assertNotNull(response);
//		//assertEquals(HttpStatus.OK, response.getStatusCode());
//		//assertEquals(mockBooks, response.getBody());
//	}
//
//	@Test
//	public void testGetBookByPricesBetween_EmptyList() {
//		Double minPrice = 100.00;
//		Double maxPrice = 200.00;
//
//		when(bookRepo.findByOnlinePriceBetween(minPrice, maxPrice)).thenReturn(new ArrayList<>());
//
//		List<Book> response = bookStoreController.getBookByPricesBetween(minPrice, maxPrice);
//
//		assertNotNull(response);
//		//assertEquals(HttpStatus.OK, response.getStatusCode());
//		//assertEquals(new ArrayList<>(), response.getBody());
//	}
}
