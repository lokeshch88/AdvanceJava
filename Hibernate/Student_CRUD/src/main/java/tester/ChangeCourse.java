package tester;

import org.hibernate.SessionFactory;

import dao.StudentsDaoImpl;
import pojos.CourseType;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class ChangeCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentsDaoImpl dao=new StudentsDaoImpl();
		try(SessionFactory sf=getFactory();
				Scanner sc= new Scanner(System.in)){
			System.out.println("enter id n course to chnge");
			System.out.println(dao.changeCourse(sc.nextInt(), CourseType.valueOf(sc.next().toUpperCase())));
		}

	}

}
