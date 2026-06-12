//Person.java
package com.nt.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity	
@Data
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@Table(name="OTM_PERSON")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer pid;
	@NonNull
	@Column(length = 30)
	private  String  pname;
	@NonNull
	@Column(length = 30)
	private  String addrs;
	
	@OneToMany(targetEntity = PhoneNumber.class,cascade = CascadeType.ALL,
			                    mappedBy = "per")
	//@OneToMany(targetEntity = PhoneNumber.class)
	//@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID")
	private Set<PhoneNumber>  phones;  //To build one to Many Association

	public  Person() {
		System.out.println("Person:: 0-param constructor::"+this.getClass());
	}
	
	
	//toString (alt+shift+s,s)
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", addrs=" + addrs + "]";
	}
	
	

}
