package cq.spring4.jdbc.transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring4TransactionTest {

	private PROPAGATION_REQUIRED_Service propagation_REQUIRED_Service;
	
	private ApplicationContext ctx;
	private BookShopDao bookShopDao;
	private BookShopService bookShopService;
	private Cashier cashier = null;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
		bookShopDao = ctx.getBean(BookShopDao.class);
		bookShopService = ctx.getBean(BookShopService.class);
		
		propagation_REQUIRED_Service = ctx.getBean(PROPAGATION_REQUIRED_Service.class);
		
		cashier = ctx.getBean(Cashier.class);
	}
	
	//测试
	@Test
	public void testBookShopService(){
		bookShopService.purchase("CQ", "1001");
	} 
	/**
	 *测试事物的传播行为 
	 */
	@Test
	public void testTransaction(){
		cashier.checkout("CQ", Arrays.asList("1001","1002"));
	}
	
	@Test
	public void testBookShopDaoFindBookPriceByIsbn() {
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}
	@Test
	public void testUpdateBookStock() {
		bookShopDao.updateBookStock("1001");
	}
	@Test
	public void testUpdateUserAccount() {
		bookShopDao.updateUserAccount("CQ", 100);
	}
	
	/**
	 *测试事物的传播行为  PROPAGATION_REQUIRED 
	 *表示当前方法必须运行在事务中。如果当前事务存在，方法将会在该事务中运行。否则，会启动一个新的事务
	 */
	@Test
	public void testPROPAGATION_REQUIRED(){
		propagation_REQUIRED_Service.methodA();
	}
}
