package com.nt.factory;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nt.sbeans.IBat;
import com.nt.sbeans.SGBat;
import com.nt.sbeans.SSBat;

@Component("cbat")
public class CricketBatFactory implements FactoryBean<IBat> {
	@Value("${bat.id}")
	private   String id;

	@Override
	public @Nullable IBat getObject() throws Exception {
		switch(id) {
		case "ssBat":
			return new SSBat();
		case "sgBat":
		   return  new  SGBat();
		default:
			throw new IllegalArgumentException("Invalid id ");
		}
	}

	@Override
	public @Nullable Class<?> getObjectType() {
		return IBat.class;
	}

}
