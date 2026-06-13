//DoctorOperationsRestController.java
package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.service.IDoctorMgmtService;
import com.nt.vo.DoctorVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/doctor-api")
@Tag(name = "doctor api",description = "API for Various activities of Doctor")
public class DcotorOperationsRestController {
	@Autowired
	private  IDoctorMgmtService  doctorService;
	
	
	@PostMapping("/save")
	@Operation(description = "inserts the doctor details  as part of Doctor Registration",
	                         summary = "saves the doctor details")
	public  ResponseEntity<String> saveDoctor(@RequestBody  DoctorVO vo){
		//use service
		String  msg=doctorService.registerDoctor(vo);
		//return ResponseEntity object
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}//method
		
	
		@PostMapping("/saveAll")
		public   ResponseEntity<String>  savedDoctors(@RequestBody List<DoctorVO> listVO){
			
	         //use service
				String msg=doctorService.registerDoctors(listVO);
				return new ResponseEntity<String>(msg,HttpStatus.CREATED);
			
		}//method
		
		@GetMapping("/find/{id}")
		public   ResponseEntity<?> fetchDoctorById(@PathVariable  Integer id){
				//use service
				DoctorVO vo=doctorService.showDoctorById(id);
				return  new ResponseEntity<DoctorVO>(vo,HttpStatus.OK);
		}
		
		
		@GetMapping("/findAll")
		public   ResponseEntity<?> fetchAllDoctors(){
				//use service
				List<DoctorVO>  listVO=doctorService.showAllDoctors();
				//return ResponseEntity object
				return new ResponseEntity<List<DoctorVO>>(listVO,HttpStatus.OK);
		}//method
		
		@PatchMapping("/updateFee/{id}/{hikePercent}")
		public   ResponseEntity<String>  updateDoctorFeeById(@PathVariable Integer id,
				                                                                                              @PathVariable float  hikePercent ){
				//use Service
				String msg=doctorService.hikeDoctorFeeById(id, hikePercent);
				return  new ResponseEntity<String>(msg,HttpStatus.OK);
			
		}//method
		
		
		@PutMapping("/update")
		public   ResponseEntity<String>  updateDoctor(@RequestBody DoctorVO vo){
			
			   //use serivce
				String  msg=doctorService.updateDoctorDetails(vo);
				return  new ResponseEntity<String>(msg,HttpStatus.OK);
		
		}//method
		
		@DeleteMapping("/delete/{id}")
		public   ResponseEntity<String>  deleteDoctorById(@PathVariable Integer id){
			   //use service
			   String msg=doctorService.removeDoctorById(id);
				return  new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		
		@DeleteMapping("/delete/{start}/{end}")
		public  ResponseEntity<String>  deleteDoctorsByFeeRange(@PathVariable  float start ,@PathVariable float end){
				//use service
				String msg=doctorService.removeDoctorsByFeeRange(start, end);
				return new  ResponseEntity<String>(msg,HttpStatus.OK);
		}
		
	}//class

    
	
	
