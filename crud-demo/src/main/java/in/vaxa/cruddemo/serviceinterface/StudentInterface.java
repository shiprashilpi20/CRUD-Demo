package in.vaxa.cruddemo.serviceinterface;

import java.util.List;

import in.vaxa.cruddemo.model.Student;

public interface StudentInterface {

	// To save new Student
	public Student saveStudent(Student student);

	// To update Student
	public Student updateStudent(Student student);

	// To fetch all Student from database
	public List<Student> findAllStudents();

	// To delete Student
	public void deleteStudent(int id);
}
