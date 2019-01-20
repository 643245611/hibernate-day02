package cn.itheima.f_criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itheima.domain.Customer;
import cn.itheima.utils.HibernateUtils;

public class Demo2 {
	@Test
	//基本查询
	public void fun1(){
		//1 获得session
		Session session = HibernateUtils.openSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//-------------------------------------------
		
		//查询所有的Customer对象
		Criteria criteria = session.createCriteria(Customer.class);
		
		List<Customer> list = criteria.list();
		
		System.out.println(list);
		
//		Customer c = (Customer) criteria.uniqueResult();
		
		//-------------------------------------------
		//4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联
		
		
	}
}
