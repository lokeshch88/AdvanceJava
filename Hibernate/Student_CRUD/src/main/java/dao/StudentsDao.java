package dao;

import java.util.List;

import pojos.CourseType;
import pojos.Student;

public interface StudentsDao {
	//add a method to insert new student details
	String registerStudent(Student std);
	
	//add method for std login
	Student loginStudent(String email,String pass);
	
	//add method to get all students for specific course
	List<Student> getStudentByCourse(CourseType c);
	
	//add method to change course
	String changeCourse(int id, CourseType c);
	
	

}
