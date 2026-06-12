package com.nt.writer;

import java.util.List;

import org.springframework.batch.infrastructure.item.Chunk;
import org.springframework.stereotype.Component;
@Component("biw")
public class BookItemWriter implements org.springframework.batch.infrastructure.item.ItemWriter<String> {

	@Override
	public void write(Chunk<? extends String> items) throws Exception {
		System.out.println("BookItemWriter.write()");
		System.out.println(" The processed items are ::"+items);
		
	}


}
