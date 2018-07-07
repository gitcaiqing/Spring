package cq.spring4.ioc.constructor;

import cq.spring4.ioc.setter.Axe;
import cq.spring4.ioc.setter.Person;
/**
 * 构造器注入
 * @author Administrator
 *
 */
public class PersonImpl_c implements Person{
	/**
	 * 默认构造器
	 */
	public PersonImpl_c() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 带参数构造器 注入所需参数axe
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
