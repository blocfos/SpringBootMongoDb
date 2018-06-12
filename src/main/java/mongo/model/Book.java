package mongo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Book")
public class Book {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String _id;
    private String title;
    private Double price;
    private Author author;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Book(String title, Double price) {
		super();
		this.title = title;
		this.price = price;
	}
	public Book() {
		
	}
	
	public Book(String title, Double price, Author author) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
	}
	@Override
    public String toString() {
        return "Book{" +
                ", title='" + title + '\'' +
                ", price=" + price +
                 ", author=" + author.getName() +
                '}';
    }
    
}
