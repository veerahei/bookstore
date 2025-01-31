package k25.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k25.bookstore.domain.Book;
import k25.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("Save a couple of books");
			repository.save(new Book("Hohto", "Stephen King", 1987, "12345", 20.0));
			repository.save(new Book("Tuntematon sotilas", "Väinö Linna", 1950, "98765", 30.0));
			repository.save(new Book("Dyyni", "Frank Herbert", 1965, "112233", 35.0));

			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
