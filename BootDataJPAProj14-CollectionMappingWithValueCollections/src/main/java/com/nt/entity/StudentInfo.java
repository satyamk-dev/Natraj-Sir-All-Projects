//StudentInfo.java
package com.nt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Table(name="JPA_STUDENT_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class StudentInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sno;
	@NonNull
	@Column(length = 30)
	private  String  sname;
	@NonNull
	@Column(length = 30)
	private  String sadd;
	
	@NonNull
	@ElementCollection
	@CollectionTable(name="STUDENT_FAVCOLORS",
	                                joinColumns = @JoinColumn(name="STUD_ID",referencedColumnName="SNO"))
	@Column(name="FAVORITE_COLORS")  //For List collection element values
	private  List<String> favColors;

	@NonNull
	@ElementCollection
	@CollectionTable(name="STUDENT_PHONES",
	                                joinColumns = @JoinColumn(name="STUD_ID",referencedColumnName="SNO"))
	@Column(name="PHONE_NUMBERS")  //For  hold Set Collection element values
	private  Set<Long> phoneNumbers;
	
	@NonNull
	@ElementCollection
	@CollectionTable(name="STUDENT_IDS",
	                                joinColumns = @JoinColumn(name="STUD_ID",referencedColumnName="SNO"))
	@MapKeyColumn(name="ID_KEY")  //for holding key of the element
	@Column(name="ID_VALUE")  //for holding  value of the element
	private  Map<String,String> idDetails;
	

}
