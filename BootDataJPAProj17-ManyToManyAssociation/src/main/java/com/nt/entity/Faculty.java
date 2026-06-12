//Faculty.java
package com.nt.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="MTM_FACULTY")
@Setter
@Getter
@RequiredArgsConstructor
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer fid;
	@NonNull
	@Column(length = 30)
	private  String  fname;
	@NonNull
	@Column(length = 30)
	private  String faddrs;
	
	@ManyToMany(targetEntity = Student.class, cascade = CascadeType.ALL, fetch =FetchType.EAGER)
	@JoinTable(name="MTM_FACULITIES_STUDENTS",
	                       joinColumns = @JoinColumn(name="FACULTY_ID",referencedColumnName = "FID"),  // owning side FK column
	                       inverseJoinColumns = @JoinColumn(name="STUDENT_ID",referencedColumnName = "SID"))  // non-owning side FK column
	private Set<Student>  studs=new HashSet<Student>();

	public Faculty() {
		System.out.println("Faculty:: 0-param constructor");
	}
	
	//to String
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", faddrs=" + faddrs + "]";
	}
	
	

}
