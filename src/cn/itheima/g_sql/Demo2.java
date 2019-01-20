package cn.itheima.g_sql;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itheima.domain.Customer;
import cn.itheima.utils.HibernateUtils;

public class Demo2 {
	@Test
	//基本查询
	public void fun2(){
		//1 获得session
		Session session = HibernateUtils.openSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//-------------------------------------------
		//1 书写sql语句
		String sql = "select * from cst_customer";
		
		//2 创建sql查询对象
		SQLQuery query = session.createSQLQuery(sql);
		//指定将结果集封装到哪个对象中
		query.addEntity(Customer.class);
		
		//3 调用方法查询结果
		List<Customer> list = query.list();
		
		System.out.println(list);
		//-------------------------------------------
		//4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联
		
		
	}
}
