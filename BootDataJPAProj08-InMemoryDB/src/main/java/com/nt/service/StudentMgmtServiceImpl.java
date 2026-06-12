package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Student;
import com.nt.repository.IStudentRepository;

@Service
public class StudentMgmtServiceImpl implements IStudentMgmtService {
	@Autowired
	private  IStudentRepository  studRepo;

	@Override
	public String saveStudent(Student st) {
		//save the object
		int idVal=studRepo.save(st).getSno();
		return "Student is saved with  id value ::"+idVal;
	}

	@Override
	public List<Student> showAllStudents() {
		return studRepo.findAll();
	}

}
