package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Politician;

public interface IPoliticianRepository extends JpaRepository<Politician, Integer> {
	
	//@Query(nativeQuery = true, value="SELECT (SYSDATE-DOB)/365.25  FROM POLITICIAN  WHERE PID=:id")  //for oracle
	
   @Query(value="SELECT  (TIMESTAMPDIFF(DAY, DOB, CURDATE()))/365.25  FROM POLITICIAN 	WHERE PID =:id",nativeQuery = true)
	public   double  calculateAgeById(int id);

}
