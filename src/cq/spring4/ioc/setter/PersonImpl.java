package cq.spring4.ioc.setter;

/**
 * Person�ӿڵ�ʵ����
 * @author Administrator
 *
 */
public class PersonImpl implements Person{

	/**
	 * ����ӿڱ�̶����Ǿ����ʵ����
	 * �ӿ���Ϊ������
	 */
	private Axe axe;
	public void setAxe(Axe axe) {
		this.axe = axe;
	}
	
	@Override
	public void useAxe() {
		//���ýӿڷ��� ������Ҫ����������ôʵ�ֵ�
		System.out.println(axe.chop());
	}
	
}
