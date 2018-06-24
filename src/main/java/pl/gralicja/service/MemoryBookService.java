package pl.gralicja.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.gralicja.model.Book;

@Service
public class MemoryBookService {

	private List<Book> list;

	public MemoryBookService() {
		list = new ArrayList<>();
		list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
		list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.", "Sierra Kathy, Bates Bert", "Helion",
				"programming"));
		list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion",
				"programming"));
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}
	
	public void addBook(Book book) {
		list.add(book);
	}
	
	public Book getBookById(long id){
		for (Book book : list) {
			if(book.getId()==id) {
				return book;	
			}
		}
		return null;
	}
	
	public void updateBook(long id, Book newBook) {
		Book book = getBookById(id);
		if(list.contains(book)) {
			int index = list.indexOf(book);
			list.add(index, newBook);
		}
	}
	
	public void deleteBook(long id) {
		Book book = getBookById(id);
		if(list.contains(book)) {
			list.remove(book);
		}
	}
}
