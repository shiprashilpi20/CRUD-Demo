package in.vaxa.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.vaxa.cruddemo.model.Student;
import in.vaxa.cruddemo.serviceinterface.StudentInterface;

@RestController
// we are using Postman to do operations for that we need to add cross origin annotation
@CrossOrigin("*")
public class HomeController {

	// To create bean of implementation class
	@Autowired
	private StudentInterface studentInterface;

	// To call save method or save new student
	@PostMapping(value = "saveStudent")
	public Student saveStudent(@RequestBody Student student) {
		studentInterface.saveStudent(student);
		return student;

	}

	@GetMapping(value = "getStudent")
	public List<Student> getAllStudent() {
		return studentInterface.findAllStudents();
	}

	@PutMapping(value = "putStudent")
	public Student updateStudent(@RequestBody Student student) {
		studentInterface.updateStudent(student);
		return student;
	}

	@DeleteMapping(value = "deleteStudent")
	public String deleteStudent(@RequestParam(value = "id") int id) {
		studentInterface.deleteStudent(id);
		return "Deleted Sucessfully";

	}
}
