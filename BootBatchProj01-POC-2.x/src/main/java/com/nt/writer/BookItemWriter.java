package com.nt.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
@Component("biw")
public class BookItemWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println("BookItemWriter.write()");
		System.out.println(" The processed items are ::"+items);
		
	}


}
