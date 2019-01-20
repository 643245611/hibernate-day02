package cn.itheima.e_hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itheima.domain.Customer;
import cn.itheima.utils.HibernateUtils;

public class Demo2 {
	//������ѯ
	@Test
		public void fun1(){
			//1 ���session
			Session session = HibernateUtils.openSession();
			//2 ��������
			Transaction tx = session.beginTransaction();
			//3ִ�в���
			//-------------------------------------------
			//1> ��дHQL���
//			String hql = " from cn.itheima.domain.Customer ";
			String hql = " from Customer "; // ��ѯ����Customer����
			//2> ����HQL��䴴����ѯ����
			Query query = session.createQuery(hql);
			//3> ���ݲ�ѯ�����ò�ѯ���
			List<Customer> list = query.list();	// ����list���
			//query.uniqueResult();//����Ψһ�Ĳ�ѯ���
			
			System.out.println(list);
			//-------------------------------------------
			//4�ύ����.�ر���Դ
			tx.commit();
			session.close();// ����|�й� ״̬, ��id , û�й���			
}
		//������ѯ
	@Test
		public void fun2(){
			//1 ���session
			Session session = HibernateUtils.openSession();
			//2 ��������
			Transaction tx = session.beginTransaction();
			//3ִ�в���
			//-------------------------------------------
			//1> ��дHQL���
//			String hql = " from cn.itheima.domain.Customer ";
			String hql = " from Customer where cust_id = 1"; // ��ѯ����Customer����
			//2> ����HQL��䴴����ѯ����
			Query query = session.createQuery(hql);
			//3> ���ݲ�ѯ�����ò�ѯ���
			Customer c = (Customer) query.uniqueResult();	// ����list���
			//query.uniqueResult();//����Ψһ�Ĳ�ѯ���
			
			System.out.println(c);
			//-------------------------------------------
			//4�ύ����.�ر���Դ
			tx.commit();
			session.close();// ����|�й� ״̬, ��id , û�й���			
}
		
}