package pl.gralicja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.gralicja.model.Book;
import pl.gralicja.service.MemoryBookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	MemoryBookService bookService;

	@RequestMapping("/hello")
	public String hello() {
		return "{hello:	World}";
	}

	@RequestMapping("/helloBook")
	public Book helloBook() {
		return new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming");
	}

	@GetMapping("/")
	public List<Book> getAllBooks() {
		return bookService.getList();
	}

	@PostMapping("/")
	public void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}

	@GetMapping("/{id}")
	public Book getOne(@PathVariable Long id) {
		return bookService.getBookById(id);
	}

	@PutMapping("/{id}")
	public void updateBook(@PathVariable long id, @RequestBody Book newBook) {
		bookService.updateBook(id, newBook);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable long id) {
		bookService.deleteBook(id);
	}

}
