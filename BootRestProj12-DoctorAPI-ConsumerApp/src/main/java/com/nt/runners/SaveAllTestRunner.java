package com.nt.runners;

import java.util.List;

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
public class SaveAllTestRunner implements CommandLineRunner {
	@Autowired
	private RestTemplate  template;

	@Override
	public void run(String... args) throws Exception {
		try {
	   //base url
		String url="http://localhost:7799/BootRestProj11-DoctorAPI-MiniProject-SwaggerOpenAPI/doctor-api/saveAll";
		
		//  prepare request body content as the json content
		/*String json_body = """
				{
				  "dname": "Dr. Rajesh Kumar",
				  "addrs": "Hyderabad",
				  "fee": 750.0,
				  "specialization": "Cardiologist"
				}""";*/
		
		  DoctorVO  vo1=new DoctorVO("suresh babu1","hyd",649.0,"cardio");
		  DoctorVO  vo2=new DoctorVO("suresh babu2","hyd",619.0,"cardio");
		  List<DoctorVO>  list=List.of(vo1,vo2);
		  ObjectMapper mapper=new  ObjectMapper();
		  String json_body=mapper.writeValueAsString(list);
		
		 //  prepare http request header
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		//prepare HttpEntity Object having  body  and headers
		HttpEntity<String> entity=new HttpEntity<String>(json_body, header);
		//invoke the method
		ResponseEntity<String> resp=template.exchange(url, HttpMethod.POST, entity, String.class);
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
