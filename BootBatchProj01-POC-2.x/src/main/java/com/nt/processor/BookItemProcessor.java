package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("bip")
public class BookItemProcessor implements ItemProcessor<String, String> {
	

	@Override
	public String process(String item) throws Exception {
		System.out.println("BookItemProcessor.process()");
		if(item.equalsIgnoreCase("CRJ"))
			return item+" By. HS-PN";
		else if(item.equalsIgnoreCase("HFJ"))
			return item+" By. KS";
		else if (item.equalsIgnoreCase("BBJ"))
			return  item+"By. RNR";
		else if(item.equalsIgnoreCase("TIJ"))
			return item +"By. BE";
		else if(item.equalsIgnoreCase("EJ"))
			return item+" By. JB";
		else	
		return null;
	}

}
