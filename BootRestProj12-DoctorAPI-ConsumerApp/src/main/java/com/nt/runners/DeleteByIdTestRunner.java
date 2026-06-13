package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nt.vo.DoctorVO;

import tools.jackson.databind.ObjectMapper;

@Component
public class DeleteByIdTestRunner implements CommandLineRunner {
	@Autowired
	private RestTemplate  template;

	@Override
	public void run(String... args) throws Exception {
		try {
	   //base url
		String url="http://localhost:7799/BootRestProj11-DoctorAPI-MiniProject-SwaggerOpenAPI/doctor-api/delete/{id}";
		//invoke the method
		ResponseEntity<String> resp=template.exchange(url, HttpMethod.DELETE, null, String.class,1008);
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
