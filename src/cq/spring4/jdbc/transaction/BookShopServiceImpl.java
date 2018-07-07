package cq.spring4.jdbc.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	
	@Autowired
	private BookShopDao bookShopDao;
	
	//3.对应得方法上添加@Transactional注解
	//@Transactional
	//propagation 指定事物的传播行为，即当前的事物方法被另一个事物调用时
	//如何使用事物 默认的事物传播行为 REQUIRED
	//Propagation.REQUIRES_NEW 开启新事物
	
	//事物隔离级别:isolation
	//isolation=Isolation.READ_COMMITTED:读已提交
	//noRollbackFor=UserAccountException.class, 异常不回滚
	//readOnly 只读取数据不更新
	//timeout 事物 执行多久后 强制回滚时间
	@Transactional(
		propagation=Propagation.REQUIRES_NEW,
		isolation=Isolation.READ_COMMITTED,
		timeout=3
		
	)
	public void purchase(String name, String isbn) {
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取价格
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//更新库存
		bookShopDao.updateBookStock(isbn);
		//更新余额
		bookShopDao.updateUserAccount(name, price);
	}

}
