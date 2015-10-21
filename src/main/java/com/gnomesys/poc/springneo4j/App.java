package com.gnomesys.poc.springneo4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gnomesys.poc.springneo4j.service.GalaxyService;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");

		GalaxyService gs = (GalaxyService) appContext.getBean("galaxyService");
		gs.makeSomeWorlds();
	}
}
