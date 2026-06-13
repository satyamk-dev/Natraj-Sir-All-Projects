package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.service.IDoctorMgmtService;
import com.nt.vo.DoctorVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class HospitalOperationsController {
	@Autowired
	private IDoctorMgmtService  doctorService;
	
	@GetMapping("/")
	public String showHomePage() {
	System.out.println("HospitalOperationsController.showHomePage()");
		  	
		//return  LVN
		return "welcome";
	}
	
	
	@GetMapping("/report")  // G-GET
	public  String showReport(Map<String,Object> map) {
		System.out.println("HospitalOperationsController.showReport()");
		//use service 
		List<DoctorVO>  listVO=doctorService.showAllDoctors();
		//keep the result in Model Attribute
		map.put("listVO", listVO);
		//return  LVN
		return "show_report";
	}
	
	@GetMapping("/add")  // for  form launching
	public    String  showAddDoctorFormPage(@ModelAttribute("dvo") DoctorVO vo) {
		System.out.println("HospitalOperationsController.showAddDoctorFormPage()");
		//return LVN
		 return  "register_doctor";
	}
	
	/*	@PostMapping("/add")   // P-POST
		public  String  registerDoctor(Map<String,Object> map, @ModelAttribute("dvo") DoctorVO vo) {
			System.out.println("HospitalOperationsController.registerDoctor()");
	      //use service 
			String msg=doctorService.registerDoctor(vo);
			//keep the result in Model Attribute
			map.put("resultMsg",msg);
			//return LVN
			return "redirect:report";  // R--Redirect
		}*/
	
	/*@PostMapping("/add")   // P-POST
	public  String  registerDoctor(RedirectAttributes attrs, @ModelAttribute("dvo") DoctorVO vo) {
		System.out.println("HospitalOperationsController.registerDoctor()");
	  //use service 
		String msg=doctorService.registerDoctor(vo);
		//keep the result in Model Attribute
		attrs.addFlashAttribute("resultMsg",msg);
		//return LVN
		return "redirect:report";  // R--Redirect
	}*/
	
	@PostMapping("/add")   // P-POST
	public  String  registerDoctor(HttpSession ses, @ModelAttribute("dvo") DoctorVO vo) {
		System.out.println("HospitalOperationsController.registerDoctor()");
	  //use service 
		String msg=doctorService.registerDoctor(vo);
		//keep the result in Model Attribute
		ses.setAttribute("resultMsg",msg);
		//return LVN
		return "redirect:report";  // R--Redirect
	}
	
	@GetMapping("/edit")
	public   String  showEditDoctorFormPage(@ModelAttribute("dvo") DoctorVO vo,
			                                                                  @RequestParam Integer id) {
		//use service
		DoctorVO vo1=doctorService.showDoctorById(id);
		//copy  data from  vo1 to vo
		BeanUtils.copyProperties(vo1, vo);
		//return LVN
		return "edit_doctor";
		
	}
	
	@PostMapping("/edit")
	public String    updateDoctorDetails(@ModelAttribute("dvo")  DoctorVO vo,
			                                                           RedirectAttributes  attrs) {
		//use service
		String msg=doctorService.updateDoctor(vo);
		// add result to model attributes
		attrs.addFlashAttribute("resultMsg", msg);
		//return LVN
		return  "redirect:report";
	}
	
	@GetMapping("/delete")
	public  String  deleteDoctor(@RequestParam  Integer id,
			                                         Map<String,Object> map) {
		//use service
		String msg=doctorService.removeDoctorById(id);
		//keep the result in  shared memory
		map.put("resultMsg", msg);
		//return LVN
		return  "forward:report";
	}

}
