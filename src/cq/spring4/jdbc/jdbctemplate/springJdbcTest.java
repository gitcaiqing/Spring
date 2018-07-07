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
	
	//具名参数jdbc
	JdbcTemplate jdbcTemplate = null;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	
		namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
	}
	/**
	 * 具名参数测试
	 * 优点：对参数命名 ，不用去一一对应
	 * 缺点：较为麻烦
	 */
	@Test
	public void testNamedParameterJdbcTemplate(){
		//参数由:argname 代替了？
		String sql = "INSERT INTO employees(last_name, email, dept_id) VALUES(:ln,:email,:deptId)";
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ln", "qq");
		paramMap.put("email", "88@qq.com");
		paramMap.put("deptId", "88");
		
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	/**
	 * 直接传递对象的方式
	 */
	@Test
	public void testNamedParameterJdbcTemplate2(){
		//:后面所带的参数为pojo类对应的属性
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
	 * 测试c3p0连接是否成功
	 */
	@Test
	public void testDataSource(){
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
	}
	/**
	 * 更新操作
	 */
	@Test
	public void testUpdate(){
		String sql = "UPDATE employees SET last_name = ? WHERE id = ?";
		jdbcTemplate.update(sql, "Caiqing", 4);
	}
	/**
	 * 测试批量更新
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
	 * 从数据库中获取一条记录, 实际得到对应的一个对象
	 * 注意不是调用 queryForObject(String sql, Class<Employee> requiredType, Object... args) 方法!
	 * 而需要调用 queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args)
	 * 1. 其中的 RowMapper 指定如何去映射结果集的行, 常用的实现类为 BeanPropertyRowMapper
	 * 2. 使用 SQL 中列的别名完成列名和类的属性名的映射. 例如 last_name lastName
	 * 3. 不支持级联属性. JdbcTemplate 到底是一个 JDBC 的小工具, 而不是 ORM 框架
	 */
	@Test
	public void testQueryForObject(){
		String sql = "SELECT id, last_name lastName, email FROM employees WHERE id = ?";
		
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 3);
		
		System.out.println(employee);
	}
	
	/**
	 * 查询实体类的集合
	 */
	@Test
	public void testQueryForList(){
		String sql = "SELECT id, last_name, email FROM employees WHERE id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		List<Employee> employees = jdbcTemplate.query(sql, rowMapper,1);
		System.out.println(employees);
	}
	
	/**
	 * 获取单个列的值 或统计查询
	 * queryForObject(sql, requiredType);
	 */
	@Test
	public void testQueryForOneObject(){
		String sql = "SELECT COUNT(*) FROM employees";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
		
	}
	
	
	
	
	
	
	
	
	
}



















