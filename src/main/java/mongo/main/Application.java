package mongo.main;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import mongo.model.Book;
import mongo.model.BookSingleton;
import mongo.repository.BookRepository;
import mongo.service.BookService;
import mongo.service.BookServiceImp;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"mongo.service", "mongo.repository"})
@EntityScan("mongo.model")
//@EnableJpaRepositories(repositoryFactoryBeanClass=BookRepository.class)
@EnableMongoRepositories("mongo.repository")
public class Application {

	@Autowired
	//@Qualifier("bookServiceImp")
	private BookService bookService;
	
	public void test() {
		System.out.println("*************************************");
		bookService.generateBooksNoPersis();
		System.out.println("*************************************");
	}
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
        	bookService.deleteAllBook();
        	bookService.generateBooksNoPersis();
        	bookService.generateBooks();
        	bookService.getAllBook();
        	//this.testJava();
        	//this.testSingleton();
        	
        };
    }
    private void testJava() {
    	int x = 0;
    	int y = x;
    	x = 10;
    	System.out.println("x" + x);
    	System.out.println("y" + y);
    	System.out.println("-------------");
    	Integer ix = new Integer(10);
    	Integer iy = ix;
    	ix = 15;
    	System.out.println("ix " + ix);
    	System.out.println("iy " + iy);
    	System.out.println("-------------");
    	Book b1 = new Book("Teuton", (double)20);
    	Book b2 = b1;
    	b1.setTitle("yoyo");
    	//b1 = new Book("Toto", (double)10);
    	System.out.println(b1.toString());
    	System.out.println(b2.toString());	
    	System.out.println("-------------");
    	testReference(b1);
    	System.out.println(b1.toString());
    }
    private void testReference(Book b) {
    	b.setTitle("PPPP");
    	b = new Book("DDDD", (double) 30);
    }
    private void testSingleton() {
    	//------------
    	BookSingleton bs3 = BookSingleton.getInstance();
    	bs3.setTitle("kkkkkk");
    	BookSingleton bs4 = BookSingleton.getInstance();
    	bs4.setTitle("lllll");
    	System.out.println(bs3.getTitle());
    	System.out.println(bs4.getTitle());
    }

}