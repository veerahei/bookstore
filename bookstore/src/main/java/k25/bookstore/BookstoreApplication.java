package k25.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k25.bookstore.domain.Book;
import k25.bookstore.domain.BookRepository;
import k25.bookstore.domain.Category;
import k25.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Save a couple of books");

			Category category1 = new Category("Horror");
			Category category2 = new Category("Scifi");
			Category category3 = new Category("History");

			crepository.save(category1);
			crepository.save(category2);
			crepository.save(category3);

			brepository.save(new Book("Hohto", "Stephen King", "123456", 1987, 20.0, category1));
			brepository.save(new Book("Tuntematon sotilas", "Väinö Linna", "98765", 1950, 30.0, category3));
			brepository.save(new Book("Dyyni", "Frank Herbert", "112233", 1965, 35.0, category2));

			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
