//PhoneNumber.java
package com.nt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@Table(name="OTM_PHONE_NUMBER")
public class PhoneNumber {
	@Id
	@SequenceGenerator(name="gen1",
	   sequenceName = "reg_seq1",initialValue = 100 ,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer regNo;
	@NonNull
	private  Long phoneNo;
@Column(length = 30)
@NonNull
	private   String type;
@Column(length = 30)
@NonNull
	private  String provider;

@ManyToOne(targetEntity = Person.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
@JoinColumn(name="PERSON_ID",referencedColumnName = "PID")
  private   Person  per;

public  PhoneNumber() {
	System.out.println("PhoneNumber:: 0-param constructor::"+this.getClass());
}

  //toString (alt+shift+s,s)
@Override
public String toString() {
	return "PhoneNumber [regNo=" + regNo + ", phoneNo=" + phoneNo + ", type=" + type + ", provider=" + provider + "]";
}
  
   
	

}
