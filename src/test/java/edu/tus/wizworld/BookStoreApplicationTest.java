package edu.tus.wizworld;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = HarryPotterBookstoreApplication.class)
public class BookStoreApplicationTest {
	
	@Test
	public void contextLoads() {
		HarryPotterBookstoreApplication.main(new String[]{});
	}
	
}