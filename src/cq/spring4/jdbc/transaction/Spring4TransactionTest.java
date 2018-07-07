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
	
	//����
	@Test
	public void testBookShopService(){
		bookShopService.purchase("CQ", "1001");
	} 
	/**
	 *��������Ĵ�����Ϊ 
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
	 *��������Ĵ�����Ϊ  PROPAGATION_REQUIRED 
	 *��ʾ��ǰ�������������������С������ǰ������ڣ����������ڸ����������С����򣬻�����һ���µ�����
	 */
	@Test
	public void testPROPAGATION_REQUIRED(){
		propagation_REQUIRED_Service.methodA();
	}
}
