//package edu.tus.hpbookstore;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import edu.tus.wizworld.dao.BookRepository;
//import edu.tus.wizworld.dto.Book;
//import edu.tus.wizworld.dto.Rating;
//import edu.tus.wizworld.errors.BookValidator;
//import edu.tus.wizworld.exceptions.BookValidationException;
//
//@ExtendWith(MockitoExtension.class)
//public class BookValidatorTest {
//
//	@InjectMocks
//	private BookValidator bookValidator;
//
//	@Mock
//	private BookRepository bookRepo;
//
//	@Test
//	public void testValidateBook_EmptyFields() throws Exception {
//		Book book = new Book((long)1,"Another Book Title", "Another Book Series", "Another Author", 20.00, 25.00, "","",Rating.CLASSIC);
//		assertThrows(BookValidationException.class, () -> bookValidator.validateBook(book));
//	}
//
//	@Test
//	public void testValidateBook_ExistingTitle() throws Exception {
//		Book book = new Book((long)1,"Another Book Title", "Another Book Series", "Another Author", 20.00, 25.00, "","",Rating.CLASSIC);
//		assertThrows(BookValidationException.class, () -> bookValidator.validateBook(book));
//	}
//
//	@Test
//	public void testValidateBook_InvalidPrice() throws Exception {
//		Book book = new Book((long)1,"Another Book Title", "Another Book Series", "Another Author", 20.00, 25.00, "","",Rating.CLASSIC);
//		assertThrows(BookValidationException.class, () -> bookValidator.validateBook(book));
//	}
//
//	@Test
//	public void testValidateBook_ValidBook() throws Exception {
//		Book book = new Book((long)1,"Another Book Title", "Another Book Series", "Another Author", 20.00, 25.00, "","",Rating.CLASSIC);
//
//		assertThrows(BookValidationException.class, ()->bookValidator.validateBook(book));
//	}
//}
