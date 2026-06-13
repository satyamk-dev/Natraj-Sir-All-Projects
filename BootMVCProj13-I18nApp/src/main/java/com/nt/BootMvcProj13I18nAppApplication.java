package com.nt;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvcProj13I18nAppApplication {
	
	@Bean(name="localeResolver") //fixed bean id  //To activate  the I18n on the Application
	public  SessionLocaleResolver  createResolver() {
		SessionLocaleResolver resolver=new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.of("en", "US"));
		return resolver;
	}
	
	@Bean(name="lci")   // To activate the interceptor for every request
	public  LocaleChangeInterceptor  createLCI() {
		LocaleChangeInterceptor interceptor=new LocaleChangeInterceptor();
		interceptor.setParamName("domain");
		return interceptor;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj13I18nAppApplication.class, args);
	}

}
