
package com.nt.runners;

import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//@Order(2)
public class ReportTestRunner2 implements ApplicationRunner,Ordered {

	@Override
	public void run(ApplicationArguments args) throws Exception {
       System.out.println("ReportTestRunner2.run() (AR)");
       System.out.println("Non option args are ::"+args.getNonOptionArgs());
       System.out.println("OPtiona Args are ::");
       Set<String> names=args.getOptionNames();
       for(String name:names) {
    	   System.out.println(" arg name:: "+name);
    	   System.out.println(" arg value ::"+args.getOptionValues(name));
       }
       
 	   System.out.println("==============");
 	   
       
	}

	@Override
	public int getOrder() {
		return 10;
	}

}
