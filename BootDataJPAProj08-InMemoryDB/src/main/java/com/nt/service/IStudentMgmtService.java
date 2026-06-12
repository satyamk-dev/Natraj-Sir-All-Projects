package com.nt.service;

import java.util.List;

import com.nt.entity.Student;

public interface IStudentMgmtService {
   public  String saveStudent(Student st);
   public  List<Student>  showAllStudents();
}
