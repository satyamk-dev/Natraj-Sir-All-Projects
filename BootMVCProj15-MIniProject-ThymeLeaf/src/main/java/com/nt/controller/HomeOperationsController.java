package com.nt.controller;

import com.nt.service.DoctorMgmtServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeOperationsController {

    private final DoctorMgmtServiceImpl doctorMgmtServiceImpl;

    HomeOperationsController(DoctorMgmtServiceImpl doctorMgmtServiceImpl) {
        this.doctorMgmtServiceImpl = doctorMgmtServiceImpl;
    }
	
	@GetMapping("/")
	public  String  showHomePage() {
		System.out.println("HomeOperationsController.showHomePage()");
		//redirect the request
		return "redirect: hospital/";
	}

}
