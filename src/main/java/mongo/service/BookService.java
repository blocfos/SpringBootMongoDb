package mongo.service;
import java.util.List;

import mongo.model.Book;
public interface BookService {
	public List<Book> getBookByTitle(String title);
	public void generateBooks();
	public List<Book> getAllBook();
	public void generateBooksNoPersis();
	public void deleteAllBook();
}
