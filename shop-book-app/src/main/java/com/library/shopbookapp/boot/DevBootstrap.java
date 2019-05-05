/**
 * @author: Mario Flores
 */

package com.library.shopbookapp.boot;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.library.shopbookapp.model.Book;
import com.library.shopbookapp.model.Detail;
import com.library.shopbookapp.repository.BookRepository;
import com.library.shopbookapp.repository.DetailRepository;

import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private DetailRepository detailRepository;
	
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
    	Detail detailGOT = new Detail();
    	//1 to 10 book state.
    	detailGOT.setCreatedOn(new Date());
    	detailGOT.setCondition(5);
    	detailGOT.setDescription("Used only for school.");
    	detailGOT.setBook(book);
    	detailRepository.save(detailGOT);
    	book.setDetail(detailGOT);
    	bookRepository.save(book);
    	//book.setDetail(detailGOT);
    	//detailGOT.setBook(book);
    	
    	
    	
//    	Book book = new Book("Game of Thrones",	"fancy", 1995, new Detail(9, "Good state"));
//    	bookRepository.save(book);
    }

}
