/**
 * @author: Mario Flores
 */

package com.library.shopbookapp.boot;



import org.junit.experimental.categories.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.library.shopbookapp.model.Area;
import com.library.shopbookapp.model.Author;
import com.library.shopbookapp.model.Book;
import com.library.shopbookapp.model.Category;
import com.library.shopbookapp.model.DetailBook;
import com.library.shopbookapp.repository.AreaRepository;
import com.library.shopbookapp.repository.AuthorRepository;
import com.library.shopbookapp.repository.BookRepository;
import com.library.shopbookapp.repository.CategoryRepository;
import com.library.shopbookapp.repository.DetailBookRepository;

import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired 
	private AuthorRepository authorRepository;
	
	@Autowired
	private DetailBookRepository detailBookRepository;
	
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

    
    	Area areaKids = new Area();
    	areaKids.setCreatedOn(new Date());
    	areaKids.setName("kids");
    	areaKids.setDescription("Books only for kids.");
    	areaRepository.save(areaKids);
    	
    	Area areaAdults = new Area();
    	areaAdults.setCreatedOn(new Date());
    	areaAdults.setName("Adults");
    	areaAdults.setDescription("Only for adults");
    	areaRepository.save(areaAdults);
    	
    	Category fictionCat = new Category();
    	fictionCat.setCreatedOn(new Date());
    	fictionCat.setName("Fiction");
    	fictionCat.setDescription("All Fiction books.");
    	fictionCat.setArea(areaKids);
    	categoryRepository.save(fictionCat);
    	//System.out.println(fictionCat.getId());
    	
    	
    	Category historyCat = new Category();
    	historyCat.setCreatedOn(new Date());
    	historyCat.setName("History");
    	historyCat.setDescription("Just history books");
    	historyCat.setArea(areaKids);
    	
    	//System.out.println(historyCat.getId());
    	categoryRepository.save(historyCat);
    	
    	Author author = new Author();
    	author.setCreatedOn(new Date());
    	author.setName("George Marthin");
    	author.setBiography("George Raymond Richard Martin, also known as GRRM, is an American novelist and short story writer in the fantasy, horror, and science fiction genres");
    	authorRepository.save(author);
    	
    	Book book = new Book();
    	book.setCreatedOn(new Date());
    	book.setTitle("Game of thrones");
    	book.setDescription("Fancy");
    	book.setYear(2000);
    	book.setCategory(fictionCat);
    	book.setAuthor(author);
    	bookRepository.save(book);
    	
    	DetailBook detailBook = new DetailBook();
    	detailBook.setCreatedOn(new Date());
    	detailBook.setBook(book);
    	//code from 1 to 10 state of book
    	detailBook.setCodeState(8);
    	detailBook.setNumberPages(200);
    	detailBook.setStateBook("Used but still new.");
    	detailBookRepository.save(detailBook);
    }

}
