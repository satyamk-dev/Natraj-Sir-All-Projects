package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nt.vo.DoctorVO;

//@Component
public class FindByIdTestRunner implements CommandLineRunner {
	@Autowired
	private RestTemplate  template;

	@Override
	public void run(String... args) throws Exception {
        
		try {
			 //Endpoint url
			String  url="http://localhost:7799/BootRestProj11-DoctorAPI-MiniProject-SwaggerOpenAPI/doctor-api/find/{id}";
			//invoke the endpoint
			DoctorVO vo=template.getForObject(url, DoctorVO.class,1006);
			System.out.println("VO class obj data ::"+vo);
			
			/* String  resp=template.getForObject(url, String.class, 1006);
			 System.out.println("response content ::"+resp);
			*/ 
				/*//convert json content to  VO class object (model)
				 ObjectMapper  mapper=new ObjectMapper();
				 DoctorVO  vo=mapper.readValue(resp, DoctorVO.class);
				 System.out.println("VO class obj data ::"+vo);
				*/
		/*	ResponseEntity<String>  resp=template.getForEntity(url, String.class,1006);
			//analyze the output
			System.out.println("Respomse content (string json)"+resp.getBody());
			System.out.println("Response status code ::"+resp.getStatusCode());
			System.out.println("Response headers ::"+resp.getHeaders());*/
			
			ResponseEntity<DoctorVO> resp=template.exchange(url,
					                                                                                    HttpMethod.GET, 
					                                                                                    null,
					                                                                                    DoctorVO.class,
					                                                                                    1006);
			System.out.println("response content ::"+resp.getBody());
			System.out.println("response status code ::"+resp.getStatusCode());
			System.out.println("response headers ::"+resp.getHeaders());
			
			System.exit(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
