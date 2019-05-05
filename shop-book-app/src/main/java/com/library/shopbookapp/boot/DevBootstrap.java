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
import com.library.shopbookapp.model.Book;
import com.library.shopbookapp.model.Category;
import com.library.shopbookapp.repository.AreaRepository;
import com.library.shopbookapp.repository.BookRepository;
import com.library.shopbookapp.repository.CategoryRepository;

import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
    	Book book = new Book();
    	book.setCreatedOn(new Date());
    	book.setTitle("Game of thrones");
    	book.setDescription("Fancy");
    	book.setYear(2000);
    	bookRepository.save(book);
    
    	Area area = new Area();
    	area.setCreatedOn(new Date());
    	area.setName("kids");
    	area.setDescription("Books only for kids.");
    	areaRepository.save(area);
    	
    	Area areaAdults = new Area();
    	areaAdults.setCreatedOn(new Date());
    	areaAdults.setName("Adults");
    	areaAdults.setDescription("Only for adults");
    	areaRepository.save(areaAdults);
    	
    	Category category = new Category();
    	category.setCreatedOn(new Date());
    	category.setName("Fiction");
    	category.setDescription("All Fiction books.");
    	category.setArea(area);
    	categoryRepository.save(category);
    	
    	Category historyCat = new Category();
    	historyCat.setCreatedOn(new Date());
    	historyCat.setName("History");
    	historyCat.setDescription("Just history books");
    	historyCat.setArea(area);
    	categoryRepository.save(historyCat);
    }

}
