package tester;

import org.hibernate.SessionFactory;

import dao.StudentsDaoImpl;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class LoginStudent {

	public static void main(String[] args) {
		StudentsDaoImpl dao=new StudentsDaoImpl();
		try(SessionFactory sf=getFactory();
				Scanner sc= new Scanner(System.in)) {
			System.out.println("enter email n password to login");
			System.out.println(dao.loginStudent(sc.next(), sc.next()));
			
		}

	}

}
