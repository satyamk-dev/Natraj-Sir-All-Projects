package com.nt.factory;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//EngineFactory.java
import com.nt.sbeans.DieselEngine;
import com.nt.sbeans.EletricEngine;
import com.nt.sbeans.IEngine;
import com.nt.sbeans.PetrolEngine;

@Component("enggFactory")
public class EngineFactory implements FactoryBean<IEngine> {
	@Value("${engg.id}")
	private  String  id;

	@Override
	public IEngine getObject() throws Exception {
     System.out.println("EngineFactory.getObject()");
		switch (id) {
		case  "pEngine": 
			  return new  PetrolEngine();
		case  "dEngine":
			  return  new  DieselEngine();
		case  "eEngine":
			   return  new  EletricEngine();
		default:
			throw new IllegalArgumentException("Invalid  Engine Type");
		}
	}

	@Override
	public @Nullable Class<?> getObjectType() {
		System.out.println("EngineFactory.getObjectType()");
		return IEngine.class;
	}
	
	@Override
	public boolean isSingleton() {
		System.out.println("EngineFactory.isSingleton()");
		return true;
	}

}
