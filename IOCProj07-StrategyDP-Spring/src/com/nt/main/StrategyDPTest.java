package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.comps.MyntraStore;
import com.nt.config.AppConfig;

public class StrategyDPTest {

	public static void main(String[] args) {
		//create  IOC container
		try(AnnotationConfigApplicationContext ctx=
				   new  AnnotationConfigApplicationContext(AppConfig.class) ){
			//get target spring bean class obj ref
			MyntraStore  store=ctx.getBean("myntra",MyntraStore.class);
			//invoke the b.method
			String resultMsg=store.shopping(new String[] {"shirt","trouser","Hat"},
					                                                      new  float[] {3000.0f , 5000.0f , 1000.0f });
			System.out.println(resultMsg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
