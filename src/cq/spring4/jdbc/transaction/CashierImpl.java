package cq.spring4.jdbc.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CashierImpl implements Cashier {
	
	@Autowired
	private BookShopService bookShopService;
	
	@Transactional
	public void checkout(String username, List<String> isbns) {
		for(String isbn:isbns){
			bookShopService.purchase("CQ", isbn);
		}
	}

}
