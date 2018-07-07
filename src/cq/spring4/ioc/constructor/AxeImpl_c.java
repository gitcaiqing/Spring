package cq.spring4.ioc.constructor;

import cq.spring4.ioc.setter.Axe;

/**
 * 构造器注入方式
 * @author Administrator
 *
 */
public class AxeImpl_c implements Axe{
	
	
	/**
	 * 添加默认构造器
	 */
	public AxeImpl_c() {
		
	}
	
	@Override
	public String chop() {
		// TODO Auto-generated method stub
		return "斧子砍东西----构造器注入";
	}

}
