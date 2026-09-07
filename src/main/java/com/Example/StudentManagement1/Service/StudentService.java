package com.Example.StudentManagement1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Example.StudentManagement1.Entity.Students;
import com.Example.StudentManagement1.Repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	

	public List<Students> getAllStudents() {
		return studentRepository.findAll();
	}

	public Students addStudent(Students student) {
		return studentRepository.save(student);
	}

	public Students getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	public Students updateStudent(Long id, Students studentDetails) {
		Students student = studentRepository.findById(id)
				.orElse(null);
		
		if(student != null) {
			
			student.setName(studentDetails.getName());
			student.setEmail(studentDetails.getEmail());
			student.setPhone(studentDetails.getPhone());
			student.setDepartment(studentDetails.getDepartment());
			student.setYear(studentDetails.getYear());
			
			return studentRepository.save(student);
			
		}
		
		return null;
		
		
	}

	public String deleteStudent(Long id) {
		
		if(studentRepository.existsById(id))
		{
			studentRepository.deleteById(id);
			
			return "Student deleted successfully";
		}
		else
			return "Student not found";
	}

}
