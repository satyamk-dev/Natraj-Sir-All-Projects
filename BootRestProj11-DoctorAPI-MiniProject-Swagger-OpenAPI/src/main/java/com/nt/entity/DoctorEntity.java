//DoctorEntity.java
package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="API_DOCTOR_TAB")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class DoctorEntity {
    //Data properties
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "DID_SEQ",initialValue = 1000 ,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private  Integer did;
	
	@Column(length = 30)
	@Nonnull
	private String  dname;
	
	@Column(length = 30)
	@Nonnull
	private  String  addrs;
	
	@Nonnull
	private   Double fee;
	
	@Column(length = 30)
	@Nonnull
	private  String  specialization;
     // Meta Data properties
	@Version
	private  Integer  updateCount;
	@CreationTimestamp
	@Column(insertable = true, updatable = false )
	private  LocalDateTime  registeredOn;
	
	@UpdateTimestamp
	@Column(insertable = false, updatable = true )
	private  LocalDateTime  lastUpdatedOn;
	
	@Column(length = 30,insertable = true,updatable=false)
	private  String  createdBy;
	@Column(length = 30,updatable = true,insertable = false)
	private   String updatedBy;
	
	@Column(length = 30)
	private  String active_SW="active";
	
}
