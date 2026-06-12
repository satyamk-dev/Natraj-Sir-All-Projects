package com.nt.service;

import java.util.List;

import com.nt.entity.Faculty;
import com.nt.entity.Student;

public interface ICollegeMgmtService {
    public  String  registerFacultiesAndTheirStudents(List<Faculty>  faculties);
    public  String  registerStudentsAndTheirFaculties(List<Student>  studs);
    public  List<Faculty>  showFacultiesAndTheirStudents();
    
}
