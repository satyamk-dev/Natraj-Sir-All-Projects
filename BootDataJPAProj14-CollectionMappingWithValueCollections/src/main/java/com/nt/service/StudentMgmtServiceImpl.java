package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.StudentInfo;
import com.nt.repository.IStudentRepository;

@Service("studService")
public class StudentMgmtServiceImpl implements IStudentMgmtService {
	@Autowired
	private  IStudentRepository studRepo;

	@Override
	public String registerStudent(StudentInfo info) {
		//use repo
		int idVal=studRepo.save(info).getSno();
		return "Student is registered with id value ::"+idVal;
	}

}
