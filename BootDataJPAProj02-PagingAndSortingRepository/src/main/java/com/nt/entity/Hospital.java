//Hospital.java
package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="JPA_HOSPITAL")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Hospital {
	@Id
	@Column(name="H_ID")
	@SequenceGenerator(name="gen1",sequenceName = "HID_SEQ1",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy =  GenerationType.SEQUENCE)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer hid;
	
	@Column(length=30,name="H_NAME")
	@NonNull
	private  String  name;
	
	@Column(length=30,name="H_LOCATION")
	@NonNull
	private  String location;
	
	@Column(name="H_SIZE")
	@NonNull
	//@Transient
	private   Integer size;

}
