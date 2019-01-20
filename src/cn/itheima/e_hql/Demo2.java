package cn.itheima.e_hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itheima.domain.Customer;
import cn.itheima.utils.HibernateUtils;

public class Demo2 {
	//基本查询
	@Test
		public void fun1(){
			//1 获得session
			Session session = HibernateUtils.openSession();
			//2 控制事务
			Transaction tx = session.beginTransaction();
			//3执行操作
			//-------------------------------------------
			//1> 书写HQL语句
//			String hql = " from cn.itheima.domain.Customer ";
			String hql = " from Customer "; // 查询所有Customer对象
			//2> 根据HQL语句创建查询对象
			Query query = session.createQuery(hql);
			//3> 根据查询对象获得查询结果
			List<Customer> list = query.list();	// 返回list结果
			//query.uniqueResult();//接收唯一的查询结果
			
			System.out.println(list);
			//-------------------------------------------
			//4提交事务.关闭资源
			tx.commit();
			session.close();// 游离|托管 状态, 有id , 没有关联			
}
		//条件查询
	@Test
		public void fun2(){
			//1 获得session
			Session session = HibernateUtils.openSession();
			//2 控制事务
			Transaction tx = session.beginTransaction();
			//3执行操作
			//-------------------------------------------
			//1> 书写HQL语句
//			String hql = " from cn.itheima.domain.Customer ";
			String hql = " from Customer where cust_id = 1"; // 查询所有Customer对象
			//2> 根据HQL语句创建查询对象
			Query query = session.createQuery(hql);
			//3> 根据查询对象获得查询结果
			Customer c = (Customer) query.uniqueResult();	// 返回list结果
			//query.uniqueResult();//接收唯一的查询结果
			
			System.out.println(c);
			//-------------------------------------------
			//4提交事务.关闭资源
			tx.commit();
			session.close();// 游离|托管 状态, 有id , 没有关联			
}
		
}