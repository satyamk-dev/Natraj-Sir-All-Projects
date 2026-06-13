//Crickter.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("cktr")
public final class Cricketer {
	@Autowired
	//@Qualifier("${bat.id}")  //  invalid  becoz  place holder can be used with out  @Value annotation
	//@Qualifier(@Value("${bat.id}"))  //invalid  @Value annotation can not be used from @Qualifier(-) annotation
	//@Qualifier(id)  //invalid becoz   variable can not  be passed to the @Qualifer(-)
	
	@Qualifier("cbat")
	private  IBat  bat;
	
	public Cricketer() {
		System.out.println("Cricketer:: 0-param constructor");
	}
	
	//b.method
	public String batting(String name) {
		System.out.println("Cricketer.batting()");
		String  msg1="Mr/Miss/Mrs"+ name+" started the batting";
		int score=bat.scoreRuns();
		String msg2=score+"  number of runs are made";
		return   msg1+"....."+msg2;
	}
	

}
