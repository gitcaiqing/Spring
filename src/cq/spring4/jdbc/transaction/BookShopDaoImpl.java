package cq.spring4.jdbc.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookShopDaoImpl implements BookShopDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql = "SELECT price FROM book WHERE isbn = ? ";
		return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
	}

	@Override
	public void updateBookStock(String isbn) {
		//������Ƿ��㹻
		String sqlfirst = "SELECT stock FROM book_stock WHERE isbn = ?";
		int stock = jdbcTemplate.queryForObject(sqlfirst, Integer.class, isbn);
		if(stock <0 || stock ==0){
			//�׳��쳣
			throw new BookStockException("��治�㣡");			
		}
		String sql = "UPDATE book_stock SET stock = stock - 1 WHERE isbn = ? ";
		jdbcTemplate.update(sql, isbn);
	}

	@Override
	public void updateUserAccount(String username, int price) {
		String sqlFirst = "SELECT balance FROM account WHERE username = ?";
		int balance = jdbcTemplate.queryForObject(sqlFirst, Integer.class, username);
		if(balance < price){
			throw new UserAccountException("����");
		}
		
		String sql = "UPDATE account SET balance = balance - ? WHERE username = ?";
		jdbcTemplate.update(sql, price,username);

	}

}























