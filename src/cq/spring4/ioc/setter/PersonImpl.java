package cq.spring4.ioc.setter;

/**
 * Person接口的实现类
 * @author Administrator
 *
 */
public class PersonImpl implements Person{

	/**
	 * 面向接口编程而不是具体的实现类
	 * 接口作为其属性
	 */
	private Axe axe;
	public void setAxe(Axe axe) {
		this.axe = axe;
	}
	
	@Override
	public void useAxe() {
		//调用接口方法 而不需要关心它是怎么实现的
		System.out.println(axe.chop());
	}
	
}
