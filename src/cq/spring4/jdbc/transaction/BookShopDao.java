package cq.spring4.jdbc.transaction;

public interface BookShopDao {
	/**������Ż�ȡ��ĵ���*/
	public int findBookPriceByIsbn(String isbn);
	/**�������ݿ⣬ʹ��Ŷ�Ӧ�ÿ�� -1*/
	public void updateBookStock(String isbn);
	/**�����û����˺���ʹusername��balance - price */
	public void updateUserAccount(String username,int price);

}
