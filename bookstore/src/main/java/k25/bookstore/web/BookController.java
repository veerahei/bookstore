package k25.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/index")
    // Method to be defined later
    public String bookMethod() {
        return null;
    }

}
