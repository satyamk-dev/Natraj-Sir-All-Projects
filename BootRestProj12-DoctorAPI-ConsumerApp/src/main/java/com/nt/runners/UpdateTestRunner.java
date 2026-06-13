package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nt.vo.DoctorVO;

import tools.jackson.databind.ObjectMapper;

//@Component
public class UpdateTestRunner implements CommandLineRunner {
	@Autowired
	private RestTemplate  template;

	@Override
	public void run(String... args) throws Exception {
		try {
	   //base url
		String url="http://localhost:7799/BootRestProj11-DoctorAPI-MiniProject-SwaggerOpenAPI/doctor-api/update";
		
		  DoctorVO  vo=new DoctorVO(1008,"suresh babu","delhi",789.0,"cardio surgeon");
		  ObjectMapper mapper=new  ObjectMapper();
		  String json_body=mapper.writeValueAsString(vo);
		
		 //  prepare http request header
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		//prepare HttpEntity Object having  body  and headers
		HttpEntity<String> entity=new HttpEntity<String>(json_body, header);
		//invoke the method
		ResponseEntity<String> resp=template.exchange(url, HttpMethod.PUT, entity, String.class);
		//get the details
		System.out.println("  Response  body ::"+resp.getBody());
		System.out.println("==================");
		System.exit(0);
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
