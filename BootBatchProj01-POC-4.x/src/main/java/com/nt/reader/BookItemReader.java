package com.nt.reader;

import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.stereotype.Component;

@Component("bir")
public class BookItemReader implements ItemReader<String> {
	private String[]  books=new String[] {"CRJ","TIJ","EJ","HFJ","BBJ"}; 
	int count=0;

	@Override
	public String read() throws Exception {
	  System.out.println("BookItemReader.read()");
		if(count<books.length) {
			return  books[count++];
		}
		else {
		  return null;
		}
	}

}
