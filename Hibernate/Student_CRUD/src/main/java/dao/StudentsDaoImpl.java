package dao;

import static utils.HibernateUtils.getFactory;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Student;

public class StudentsDaoImpl implements StudentsDao {

	@Override
	public String registerStudent(Student std) {
		String msg="Student registration failed!!";
		
		Session session=getFactory().getCurrentSession(); // takes out conn from db conn pool
		
		Transaction tx=session.beginTransaction();
		try {
			Serializable id= session.save(std);
			tx.commit();
			msg="Registration successfully with Id: "+id;
			
		}catch (Exception e) {
			if(tx !=null)
				tx.rollback();
			throw e;
		}
		
		return msg;
	}

	@Override
	public Student loginStudent(String email1, String pass1) {
		Student s=null;
		//String msg="Invalid Credentials, Login failed!!";
		 String jpql="select s from Student s where s.email=:em and s.password=:pass";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			s=session.createQuery(jpql, Student.class)
					.setParameter("em", email1)
					.setParameter("pass", pass1)
					.getSingleResult();
			tx.commit();
			System.out.println( "Login Successfull");
			
					
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return s;
	}

}
