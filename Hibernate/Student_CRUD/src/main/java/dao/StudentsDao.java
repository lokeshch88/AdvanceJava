package dao;

import pojos.Student;

public interface StudentsDao {
	//add a method to insert new student details
	String registerStudent(Student std);
	
	//add method for std login
	Student loginStudent(String email,String pass);

}
