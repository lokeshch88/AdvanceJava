package tester;

import org.hibernate.SessionFactory;

import dao.StudentsDaoImpl;
import pojos.CourseType;
import pojos.Student;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;


public class RegisterStudent {
	public static void main(String[] args) {
		StudentsDaoImpl dao=new StudentsDaoImpl();
		
		try(SessionFactory sf=getFactory();
				Scanner sc= new Scanner(System.in)){
			
			System.out.println("Enter: firstName, lastName, email,password, course, dob");
			Student s1= new Student(sc.next(), sc.next(), sc.next(), sc.next(),
					CourseType.valueOf(sc.next().toUpperCase()), 
					LocalDate.parse(sc.next()));
			System.out.println(dao.registerStudent(s1));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
