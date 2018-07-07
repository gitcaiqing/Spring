package cq.spring4.jdbc.jdbctemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class springJdbcTest {
	ApplicationContext ctx = null;
	
	//��������jdbc
	JdbcTemplate jdbcTemplate = null;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	
		namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
	}
	/**
	 * ������������
	 * �ŵ㣺�Բ������� ������ȥһһ��Ӧ
	 * ȱ�㣺��Ϊ�鷳
	 */
	@Test
	public void testNamedParameterJdbcTemplate(){
		//������:argname �����ˣ�
		String sql = "INSERT INTO employees(last_name, email, dept_id) VALUES(:ln,:email,:deptId)";
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ln", "qq");
		paramMap.put("email", "88@qq.com");
		paramMap.put("deptId", "88");
		
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	/**
	 * ֱ�Ӵ��ݶ���ķ�ʽ
	 */
	@Test
	public void testNamedParameterJdbcTemplate2(){
		//:���������Ĳ���Ϊpojo���Ӧ������
		String sql = "INSERT INTO employees(last_name, email, dept_id) VALUES(:lastName,:email,:deptId)";

		Employee employee = new Employee();
		employee.setLastName("haha");
		employee.setEmail("haha@qq.com");
		employee.setDeptId(99);
		SqlParameterSource paramSource =  new BeanPropertySqlParameterSource(employee);

		namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	
	//==============================================//	
	
	/**
	 * ����c3p0�����Ƿ�ɹ�
	 */
	@Test
	public void testDataSource(){
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
	}
	/**
	 * ���²���
	 */
	@Test
	public void testUpdate(){
		String sql = "UPDATE employees SET last_name = ? WHERE id = ?";
		jdbcTemplate.update(sql, "Caiqing", 4);
	}
	/**
	 * ������������
	 */
	@Test
	public void testBatchUpdate(){
		String sql = "INSERT INTO employees(last_name, email, dept_id)" +
				"VALUES(?, ?, ?)";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[]{"aa","120@qq.com","2"});
		batchArgs.add(new Object[]{"bb","121@qq.com","2"});
		batchArgs.add(new Object[]{"cc","122@qq.com","2"});
		batchArgs.add(new Object[]{"dd","123@qq.com","2"});
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	
	/**
	 * �����ݿ��л�ȡһ����¼, ʵ�ʵõ���Ӧ��һ������
	 * ע�ⲻ�ǵ��� queryForObject(String sql, Class<Employee> requiredType, Object... args) ����!
	 * ����Ҫ���� queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args)
	 * 1. ���е� RowMapper ָ�����ȥӳ����������, ���õ�ʵ����Ϊ BeanPropertyRowMapper
	 * 2. ʹ�� SQL ���еı�����������������������ӳ��. ���� last_name lastName
	 * 3. ��֧�ּ�������. JdbcTemplate ������һ�� JDBC ��С����, ������ ORM ���
	 */
	@Test
	public void testQueryForObject(){
		String sql = "SELECT id, last_name lastName, email FROM employees WHERE id = ?";
		
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 3);
		
		System.out.println(employee);
	}
	
	/**
	 * ��ѯʵ����ļ���
	 */
	@Test
	public void testQueryForList(){
		String sql = "SELECT id, last_name, email FROM employees WHERE id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper,1);
		System.out.println(employees);
	}
	
	/**
	 * ��ȡ�����е�ֵ ��ͳ�Ʋ�ѯ
	 * queryForObject(sql, requiredType);
	 */
	@Test
	public void testQueryForOneObject(){
		String sql = "SELECT COUNT(*) FROM employees";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
		
	}
	
	
	
	
	
	
	
	
	
}



















