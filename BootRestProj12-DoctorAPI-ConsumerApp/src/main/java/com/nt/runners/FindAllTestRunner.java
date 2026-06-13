package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nt.vo.DoctorVO;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

//@Component
public class FindAllTestRunner implements CommandLineRunner {
	
	@Autowired
	private  RestTemplate  template;
	

	@Override
	public void run(String... args) throws Exception {
		try {
			 //Endpoint url
			String  url="http://localhost:7799/BootRestProj11-DoctorAPI-MiniProject-SwaggerOpenAPI/doctor-api/findAll";
			//invoke the endpoint
			ResponseEntity<String>  resp=template.exchange(url, HttpMethod.GET, null, String.class);
			System.out.println("Response content::"+resp.getBody());
			System.out.println("response status code ::"+resp.getStatusCode());
			System.out.println("response headers ::"+resp.getHeaders());
			
			// convert array of json docs to List<VO> object
			ObjectMapper mapper=new ObjectMapper();
			List<DoctorVO>  listVO=mapper.readValue(resp.getBody(), new TypeReference<List<DoctorVO>>() {});
			listVO.forEach(System.out::println);
			System.exit(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
