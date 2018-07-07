package cq.spring4.jdbc.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("propagation_REQUIRED_Service")
public class PROPAGATION_REQUIRED_Service {

	@Transactional
	public void methodA() {
		System.out.println("aaaaaaaaa");
	}
}
