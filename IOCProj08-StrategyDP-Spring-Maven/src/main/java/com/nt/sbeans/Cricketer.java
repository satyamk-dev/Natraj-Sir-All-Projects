//Crickter.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cktr")
//@Component
@Scope("prototype")
//@Scope("request")

public final class Cricketer {
	@Autowired
	@Qualifier("sgBat")
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
