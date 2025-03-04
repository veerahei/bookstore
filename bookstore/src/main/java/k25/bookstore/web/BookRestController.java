package k25.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import k25.bookstore.domain.Book;
import k25.bookstore.domain.BookRepository;

@RestController
public class BookRestController {

    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/bookById/{id}")
    Optional<Book> getBookByid(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    @GetMapping("/books/category/{name}")
    List<Book> getBookByCategory(@PathVariable String name) {
        return bookRepository.findByCategoryName(name);
    }

    @GetMapping("/books/{author}")
    List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookRepository.findByAuthor(author);
    }

    @PostMapping("/addBook")
    Book addBook(@RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }

    @PutMapping("/editBook/{id}") // To be tested
    Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
        editedBook.setId(id);
        return bookRepository.save(editedBook);
    }

    @DeleteMapping("/deleteBook/{id}")
    public Iterable<Book> deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return bookRepository.findAll();
    }
}
