package com.nt.main;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;

public class SpringI18nTest {

	public static void main(String[] args) {
		// create  IOC container
		try(AnnotationConfigApplicationContext  ctx=
				           new AnnotationConfigApplicationContext(AppConfig.class);
				  Scanner sc=new Scanner(System.in);
				){
			System.out.println("Enter  language code ::");
			String  languageCode=sc.next();
			System.out.println("Enter  country code ::");
			String countryCode=sc.next();
			//prepare Locale object
			Locale locale=Locale.of(languageCode, countryCode);
			//read the message from locale specific properties file
			String msg1=ctx.getMessage("wish.message", new Object[] {"raja"}, locale);
			String msg2=ctx.getMessage("goodbye.message", new Object[] { }, locale);
			String msg3=ctx.getMessage("angry.message", new Object[] { }, locale);
			System.out.println(msg1+"...."+msg2+"....."+msg3);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
