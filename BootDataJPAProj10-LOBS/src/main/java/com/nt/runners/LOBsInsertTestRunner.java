package com.nt.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.nt.entity.Actor;
import com.nt.service.IActorMgmtService;

//@Component
public class LOBsInsertTestRunner implements CommandLineRunner {
	@Autowired
	private IActorMgmtService  actorService;

	@Override
	public void run(String... args) throws Exception {
	   try(Scanner sc=new Scanner(System.in)){
		   System.out.println("Enter actor name ::");
		   String  name=sc.next();
		   System.out.println("Enter  actor address::");
		   String addrs=sc.next();
		   System.out.println("Enter actor photo path::");
		   String  photoPath=sc.next().trim();
		   System.out.println("Enter actor resume path::");
		   String  resumePath=sc.next().trim();
		   
		   byte[]  photoContent=null;
		   char[]  resumeContent=null;
		   //  create  InputSteam  pointing to   photo file
		   //  create   Reader Stream pointing to resume file
		   try(FileInputStream fis=new FileInputStream(photoPath);
				  FileReader reader=new FileReader(resumePath);
				   ){
			      //convert  photo file content to  byte[]
			      photoContent=new byte[fis.available()];
			      fis.read(photoContent);
			      //convert  resume file content to  char[]
			      File file=new File(resumePath);
			      resumeContent=new char[(int)file.length()];
			      reader.read(resumeContent);
		   }
		   //create  Entity class object
		   Actor actor=new Actor(name, addrs, photoContent, resumeContent);
		   //invoke the service class method
		   String msg=actorService.regsiterActor(actor);
		   System.out.println(msg);
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }

	}
}
