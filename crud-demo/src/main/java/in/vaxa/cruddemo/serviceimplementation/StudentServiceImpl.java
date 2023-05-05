package in.vaxa.cruddemo.serviceimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import in.vaxa.cruddemo.model.Student;
import in.vaxa.cruddemo.serviceinterface.StudentInterface;

@Service
public class StudentServiceImpl implements StudentInterface {
	List<Student> students = new ArrayList<>();
	int counter=1;
	//@Autowired
	//private StudentRepository studentRepo;
	@Override
	public Student saveStudent(Student student) {
		student.setId(counter);
		counter++;
		// TODO Auto-generated method stub
		//return studentRepo.save(student);
		students.add(student);
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		for(Student s : students ) {
			if(s.getId()==student.getId()) {
				s.setName(student.getName());
				s.setAddress(student.getAddress());
				s.setRoll(student.getRoll());
				break;
			}
		}
		// TODO Auto-generated method stub
		// return studentRepo.save(student); // same save method is used to save new student and update student
		return student;
	}

	@Override
	public List<Student> findAllStudents() {
		
		//returns a List so casting is needed
		// return (List<Student>) studentRepo.findAll();
		return students;
	}  	

	@Override
	public void deleteStudent(int id) {
		// To delete student
		// studentRepo.deleteById(id);
		Student temp = null;
		for (Student s : students) { // for each Student s in students
			if (s.getId() == id) {
				temp = s;
			}
		}
		students.remove(temp);
	}

}
