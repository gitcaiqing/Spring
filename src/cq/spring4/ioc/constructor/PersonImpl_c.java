package cq.spring4.ioc.constructor;

import cq.spring4.ioc.setter.Axe;
import cq.spring4.ioc.setter.Person;
/**
 * ������ע��
 * @author Administrator
 *
 */
public class PersonImpl_c implements Person{
	/**
	 * Ĭ�Ϲ�����
	 */
	public PersonImpl_c() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * ������������ ע���������axe
	 */
	private Axe axe;
	public PersonImpl_c(Axe axe){
		this.axe = axe;
	}
	

	@Override
	public void useAxe() {
		// TODO Auto-generated method stub
		System.out.println(axe.chop());
	}
	
}
