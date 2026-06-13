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

@RestController
@RequestMapping("/doctor-api")
public class DcotorOperationsRestController {
	@Autowired
	private  IDoctorMgmtService  doctorService;
	
	
	@PostMapping("/save")
	public  ResponseEntity<String> saveDoctor(@RequestBody  DoctorVO vo){
		try {
		//use service
		String  msg=doctorService.registerDoctor(vo);
		//return ResponseEntity object
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("Problem::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
	}//method
		
	
		@PostMapping("/saveAll")
		public   ResponseEntity<String>  savedDoctors(@RequestBody List<DoctorVO> listVO){
			
			try {
	         //use service
				String msg=doctorService.registerDoctors(listVO);
				return new ResponseEntity<String>(msg,HttpStatus.CREATED);
			}
			catch(Exception e) {
				return new ResponseEntity<String>("Problem::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}//method
		
		@GetMapping("/find/{id}")
		public   ResponseEntity<?> fetchDoctorById(@PathVariable  Integer id){
			try {
				//use service
				DoctorVO vo=doctorService.showDoctorById(id);
				return  new ResponseEntity<DoctorVO>(vo,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<String>("Problem::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
						
			}
			
		}
		
		
		@GetMapping("/findAll")
		public   ResponseEntity<?> fetchAllDoctors(){
			try {
				//use service
				List<DoctorVO>  listVO=doctorService.showAllDoctors();
				//return ResponseEntity object
				return new ResponseEntity<List<DoctorVO>>(listVO,HttpStatus.OK);
				}
			catch(Exception e) {
				return new ResponseEntity<String>("Problem::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
						
			}
		}//method
		
		@PatchMapping("/updateFee/{id}/{hikePercent}")
		public   ResponseEntity<String>  updateDoctorFeeById(@PathVariable Integer id,
				                                                                                              @PathVariable float  hikePercent ){
			try {
				//use Service
				String msg=doctorService.hikeDoctorFeeById(id, hikePercent);
				return  new ResponseEntity<String>(msg,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<String>("Problem::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}//method
		
		
		@PutMapping("/update")
		public   ResponseEntity<String>  updateDoctor(@RequestBody DoctorVO vo){
			
			try {
			   //use serivce
				String  msg=doctorService.updateDoctorDetails(vo);
				return  new ResponseEntity<String>(msg,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<String>("Problem::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
							
			}
		
		}//method
		
		@DeleteMapping("/delete/{id}")
		public   ResponseEntity<String>  deleteDoctorById(@PathVariable Integer id){
		   try {
			   //use service
			   String msg=doctorService.removeDoctorById(id);
				return  new ResponseEntity<String>(msg,HttpStatus.OK);
		   }
		   catch(Exception e) {
				return new ResponseEntity<String>("Problem::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
				   
		   }
		}
		
		@DeleteMapping("/delete/{start}/{end}")
		public  ResponseEntity<String>  deleteDoctorsByFeeRange(@PathVariable  float start ,@PathVariable float end){
			try {
				//use service
				String msg=doctorService.removeDoctorsByFeeRange(start, end);
				return new  ResponseEntity<String>(msg,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<String>("Problem::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
		}
		
	}//class

    
	
	
