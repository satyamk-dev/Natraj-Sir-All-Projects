//ShowHomeController.java
package com.nt.controller;


import java.io.PrintWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ShowHomeController {
	
	/*@RequestMapping("/home")
	//@RequestMapping({"/","/home"})
	public   String   showHomePage(BindingAwareModelMap  map) {
		// add model attributes to shared memory
		map.addAttribute("sysDate", new Date());
		map.addAttribute("age", new Random().nextInt(100));
		
		
		//return LVN
		return "welcome";
	}*/
	
	
	/*@RequestMapping("/home")
	public   String   showHomePage(Map<String,Object> map) {
		System.out.println("shared memory object class name::"+map.getClass());
		// add model attributes to shared memory
		map.put("sysDate", new Date());
		map.put("age", new Random().nextInt(100));
		
		
		//return LVN
		return "welcome";
	}
	*/
	
	/*@RequestMapping("/home")
	public   String   showHomePage(Model model) {
		System.out.println("shared memory object class name::"+model.getClass());
		// add model attributes to shared memory
		model.addAttribute("sysDate",new Date());
		model.addAttribute("age", new Random().nextInt(1000));
		//return LVN
		return "welcome";
	}*/
	
	/*@RequestMapping("/home")
	public   String   showHomePage(ModelMap  map) {
		System.out.println("Shared memory object class name::"+map.getClass());
		// add model attributes to shared memory
		map.addAttribute("sysDate",new Date());
		map.addAttribute("age", new Random().nextInt(1000));
		//return LVN
		return "welcome";
	}*/
	
	/*@RequestMapping("/home")
	public   BindingAwareModelMap   showHomePage() {
		//create  Shared Memory object
		BindingAwareModelMap  map=new BindingAwareModelMap();
		map.put("sysDate", new Date());
		map.put("age",  new Random().nextInt(1000));
		//return  shared memory
		return  map;
	}*/
	
	/*	@RequestMapping("/home")
		public   Model   showHomePage() {
			//create  Shared Memory object
			Model model=new BindingAwareModelMap();
		    model.addAttribute("sysDate", new Date());
			model.addAttribute("age",  new Random().nextInt(100));
			//return  shared memory
			return  model;
		}
	*/
	
	/*@RequestMapping("/home")
	public   Map   showHomePage() {
		//create  Shared Memory object
		Map<String,Object> map=new HashMap<String, Object>();
		//add model attributes
		map.put("sysDate",new Date());
		map.put("age", new Random().nextInt(100));
		//return  shared memory
		return  map;
	}
	*/
	
	/*@RequestMapping("/home")
	public   ModelAndView   showHomePage() {
		//create  Shared Memory object
		ModelAndView mav=new ModelAndView();
		//add model attributes
		mav.addObject("sysDate",new Date());
		mav.addObject("age", new Random().nextInt(100));
		//add view name
		mav.setViewName("welcome");
		//return  shared memory
		return  mav;
	}*/
	
	/*@RequestMapping("/home")
	public   String   showHomePage(Map<String,Object> map) {
		// add model attributes to shared memory
		map.put("sysDate",new Date());
		map.put("age",new Random().nextInt(200));
		//return LVN
		return "welcome";
	}*/
	
	/*@RequestMapping("/home")
	public   void   showHomePage(Map<String,Object> map) {
		// add model attributes to shared memory
		map.put("sysDate",new Date());
		map.put("age",new Random().nextInt(200));
	}*/
	
	/*@RequestMapping("/home")
	public   String   showHomePage(Map<String,Object> map) {
		System.out.println("ShowHomeController.showHomePage()");
		// add model attributes to shared memory
		map.put("sysDate",new Date());
		map.put("age",new Random().nextInt(200));
		//return "forward:report";
		return  "redirect:report?p1=val1&p2=val2";
	}
	@RequestMapping("/report")
	public  String  showReportPage(Map<String,Object>  map) {
	System.out.println("ShowHomeController.showReport()");
	map.put("name","raja");
	return "show_report";
	}*/
	
	/*@RequestMapping("/home")
	public   String   showHomePage(Map<String,Object> map,HttpServletRequest req, 
			                                                                                                           HttpServletResponse res) {
		//add model attributes
		map.put("sysDate",new Date());
		map.put("age",new Random().nextInt(200));
		
		res.setContentType("text/html");
		
		// model attributes uisng req, res objs
		map.put("url", req.getRequestURL());
		map.put("method",req.getMethod());
		map.put("contentType", res.getContentType());
	
		return "welcome";
		}
	*/
	
	@Autowired
	private ServletConfig  cg;
	@Autowired
	private ServletContext sc;
	
	/*@RequestMapping("/home")
	public   String   showHomePage(Map<String,Object> map,HttpSession ses) {
	  //add session attributes
		  ses.setAttribute("username", "rajesh");
		  //  add servlet class name  as model attribute
		  map.put("sname", cg.getServletName());
		  map.put("contextPath",sc.getContextPath());
		  
		 //return LVN
		  return "welcome";
	}*/
	
	@RequestMapping("/home")
	public   void   showHomePage(Map<String,Object> map,HttpServletResponse res)throws Exception {
		// get PrintWriter object
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		// make output as downaloable file
		//res.setHeader("Content-Disposition", "attachment;fileName=abc.html");
		res.setHeader("Content-Disposition", "inline");
		//write the output
		pw.println("<b> hello, how are u ? </b>");
		
	}
		
	
	
}
