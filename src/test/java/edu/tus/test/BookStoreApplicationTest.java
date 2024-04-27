package edu.tus.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.tus.wizworld.HarryPotterBookstoreApplication;

@SpringBootTest(classes = HarryPotterBookstoreApplication.class)
public class BookStoreApplicationTest {
	
	@Test
	public void contextLoads() {
		HarryPotterBookstoreApplication.main(new String[]{});
	}
	
}