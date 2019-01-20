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
	//������ѯ
	public void fun2(){
		//1 ���session
		Session session = HibernateUtils.openSession();
		//2 ��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//-------------------------------------------
		//1 ��дsql���
		String sql = "select * from cst_customer";
		
		//2 ����sql��ѯ����
		SQLQuery query = session.createSQLQuery(sql);
		//ָ�����������װ���ĸ�������
		query.addEntity(Customer.class);
		
		//3 ���÷�����ѯ���
		List<Customer> list = query.list();
		
		System.out.println(list);
		//-------------------------------------------
		//4�ύ����.�ر���Դ
		tx.commit();
		session.close();// ����|�й� ״̬, ��id , û�й���
		
		
	}
}
