package com.nt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Faculty;
import com.nt.entity.Student;
import com.nt.repository.IFacultyRepository;
import com.nt.repository.IStudentRepository;
@Service
public class CollegeMgmtServiceImpl implements ICollegeMgmtService {
	@Autowired
	private   IFacultyRepository  facultyRepo;
	@Autowired
	private   IStudentRepository  studentRepo;
	

	@Override
	public String registerFacultiesAndTheirStudents(List<Faculty> faculties) {
		//use repo
		List<Faculty> savedFaculties=facultyRepo.saveAll(faculties);
		//get saved ids
		List<Integer>  ids=savedFaculties.stream().map(Faculty::getFid).collect(Collectors.toList());
		return ids.size()+" no.of faculties and their students are saved with id values::"+ids;
	}


	@Override
	public String registerStudentsAndTheirFaculties(List<Student> studs) {
		//use repo
		List<Student> savedStuds=studentRepo.saveAll(studs);
		//get saved ids
		List<Integer>  ids=savedStuds.stream().map(Student::getSid).collect(Collectors.toList());
		return ids.size()+" no.of faculties and their students are saved with id values::"+ids;
	}
	
	@Override
	public List<Faculty> showFacultiesAndTheirStudents() {
		return facultyRepo.findAll();
	}

}
