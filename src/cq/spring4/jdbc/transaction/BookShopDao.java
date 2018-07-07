package cq.spring4.jdbc.transaction;

public interface BookShopDao {
	/**根据书号获取书的单价*/
	public int findBookPriceByIsbn(String isbn);
	/**更新数据库，使书号对应得库存 -1*/
	public void updateBookStock(String isbn);
	/**更新用户的账号余额：使username的balance - price */
	public void updateUserAccount(String username,int price);

}
