package k25.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    // Nämä on itse luotuja tietokantapyyntöjä:
    List<Book> findByCategoryName(String name);

    List<Book> findByAuthor(String author);

}