//Student.java
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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="MTM_STUDENT")
@RequiredArgsConstructor
@Setter
@Getter
public class Student {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "SID_SEQ",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private  Integer sid;
	@NonNull
	@Column(length = 30)
	private String  sname;
	@NonNull
	@Column(length = 30)
	private  String sadd;
	
	@ManyToMany(targetEntity = Faculty.class,
			                       cascade = CascadeType.ALL,
			                       fetch = FetchType.EAGER,
			                       mappedBy = "studs")
	private  Set<Faculty> factulties=new HashSet<Faculty>();
	
	public Student() {
		System.out.println("Student:: 0-param constructor");
	}

	
	
	//toString()
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sadd=" + sadd + "]";
	}
	

}
