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
	//������ѯ
	public void fun1(){
		//1 ���session
		Session session = HibernateUtils.openSession();
		//2 ��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//-------------------------------------------
		
		//��ѯ���е�Customer����
		Criteria criteria = session.createCriteria(Customer.class);
		
		List<Customer> list = criteria.list();
		
		System.out.println(list);
		
//		Customer c = (Customer) criteria.uniqueResult();
		
		//-------------------------------------------
		//4�ύ����.�ر���Դ
		tx.commit();
		session.close();// ����|�й� ״̬, ��id , û�й���
		
		
	}
}
