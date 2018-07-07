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
	
	//3.��Ӧ�÷��������@Transactionalע��
	//@Transactional
	//propagation ָ������Ĵ�����Ϊ������ǰ�����﷽������һ���������ʱ
	//���ʹ������ Ĭ�ϵ����ﴫ����Ϊ REQUIRED
	//Propagation.REQUIRES_NEW ����������
	
	//������뼶��:isolation
	//isolation=Isolation.READ_COMMITTED:�����ύ
	//noRollbackFor=UserAccountException.class, �쳣���ع�
	//readOnly ֻ��ȡ���ݲ�����
	//timeout ���� ִ�ж�ú� ǿ�ƻع�ʱ��
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
		//��ȡ�۸�
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		//���¿��
		bookShopDao.updateBookStock(isbn);
		//�������
		bookShopDao.updateUserAccount(name, price);
	}

}
