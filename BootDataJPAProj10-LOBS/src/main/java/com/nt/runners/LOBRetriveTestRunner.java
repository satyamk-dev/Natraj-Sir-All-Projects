package com.nt.runners;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;
import com.nt.service.IActorMgmtService;

@Component
public class LOBRetriveTestRunner implements CommandLineRunner {
	@Autowired
	private  IActorMgmtService  actorService;

	@Override
	public void run(String... args) throws Exception {
		
		//  Read the inputs
		try(Scanner  sc=new Scanner(System.in)){
			System.out.println("Enter  actor id");
			int  aid=sc.nextInt();
			
			//invoke the method
			Actor  actor=actorService.showActorById(aid);
			
			System.out.println("Actor  details are ");
			System.out.println(actor.getAid()+"...."+actor.getAname()+"...."+actor.getAddrs());
			
		    byte[]  photoContent=actor.getPhoto();
		    char[]   resumeContent=actor.getResume();
		    
		    try(FileOutputStream fos=new FileOutputStream("photo_retrieved.jpeg");
		    	   FileWriter  writer=new FileWriter("resume_retrived.txt");
		    		){
		    	   fos.write(photoContent);
		    	   writer.write(resumeContent);
		           System.out.println("Photo and resume docs  are  retrieved and saved");    	
		    }//try2
		  	
		}//try1
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
