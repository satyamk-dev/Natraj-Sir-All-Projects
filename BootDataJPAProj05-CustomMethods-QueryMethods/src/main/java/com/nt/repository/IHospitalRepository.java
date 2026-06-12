package com.nt.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Hospital;

public interface IHospitalRepository extends JpaRepository<Hospital, Integer>    {
	
	//Entity Queries
	//@Query("from Hospital  where  location in(?1,?2,?3) order by location")
	//@Query("from Hospital  where  location in(:l1,:l2,:l3) order by location")
	//public  List<Hospital>  showHospitalsByLocations(@Param("l1") String loc1,@Param("l2")String loc2,@Param("l3")String loc3);
    
    
	//@Query("from Hospital  where  location in(:loc1,:loc2,:loc3) order by location")
	@Query("from Hospital  where location in(?1,?2, ?3) order by location")
	public  List<Hospital>  showHospitalsByLocations( String loc1,String loc2,String loc3);
	
	//Bulk Select Entity query
	
	@Query("from Hospital  where  size >=:start and size<=:end")
	public  List<Hospital>  fetchHospitalsByBedSize(int start,int end);
    
    //Buik select  scalar query that selects specific multiple col values
	@Query("select  name,location,size from Hospital  where  size >=:start and size<=:end")
	public  List<Object[]>  fetchHospitalsDataByBedSize(int start,int end);
    
	
	//Buik select  scalar query that selects specific multiple col values
		@Query("select  name from Hospital  where  location in(:loc1,:loc2,:loc3)")
		public  List<String>  fetchHospitalsNameByBedSize(String loc1,String loc2,String loc3);
		
		
		// Single row  entity row
		@Query("from   Hospital  where name=:nam")
		public  Optional<Hospital>   getHospitalByName(String nam);
		
		@Query("select  hid,name,location  from   Hospital  where name=:nam")
			public   Object   getHospitalDataByName(String nam);
		
		
		@Query("select  location  from   Hospital  where name=:nam")
		public   String   getHospitalLocationByName(String nam);
		
		
		//  HQL  Aggragate operations
		@Query("  select  count(distinct location)  from  Hospital")
		public   long    getUnquiteLocationsCount();
		
		@Query("  select count(*) ,max(size), min(size),avg(size), sum(size)  from Hospital")
		public   Object   getHospitalAggregateData();
		
		
	
		//Non Select Operations
		@Query("update  Hospital  set size=size+ (size* :hikePercent/100)  where location=:loc")
		@Modifying
		@Transactional
		public int updateHospitalSizeByLocation(String loc , double hikePercent);
		
		
		@Modifying
		@Transactional
		@Query("delete from  Hospital  where size>=:startSize  and size<=:endSize")
		public int deleteHospitalsBySizeRange(int startSize,int endSize);
		
		
		//native SQL Query
		@Query(value="select now() from dual",nativeQuery = true)
		public LocalDateTime   showSysDateAndTime();
		
		
		
		
		
	    
		
  
}
