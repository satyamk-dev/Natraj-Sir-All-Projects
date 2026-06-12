package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.nt.sbeans.TrainingInstitute;

@SpringBootApplication
@PropertySource("com/nt/commons/myfile.properties")
public class BootIocProj10ValueAnnotationSpelApplication {

	public static void main(String[] args) {
		          //create  IOC container
		try(ConfigurableApplicationContext ctx=SpringApplication.run(BootIocProj10ValueAnnotationSpelApplication.class, args)){
			   //get spring bean  class obj ref
			  TrainingInstitute   institute=ctx.getBean("training",TrainingInstitute.class);
			  System.out.println(institute);
			  System.out.println("-----------------------");
			  double finaAmount=institute.finalFeel(10.0);
			  System.out.println(finaAmount);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
