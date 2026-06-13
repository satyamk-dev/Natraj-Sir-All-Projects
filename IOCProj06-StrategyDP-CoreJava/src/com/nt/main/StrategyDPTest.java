package com.nt.main;

import com.nt.comps.MyntraStore;
import com.nt.factory.MytraStoreFactory;

public class StrategyDPTest {

	public static void main(String[] args) {
		// get tagret class object
		MyntraStore  store=MytraStoreFactory.getInstance("dhl");
		System.out.println("----------------");
		//invoke the b.method
		String resultMsg=store.shopping(new String[] {"flag","kurtha","sweets"},
				                                                     new float[] {100.0f, 3000.0f,4000.0f});
		
		System.out.println(resultMsg);
       System.out.println("--------------------");
	}

}
