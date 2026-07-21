package com.springcore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("laptopconfig.xml");
		Laptop l1 = (Laptop) context.getBean("laptop1");
		System.out.println(l1);

		context.registerShutdownHook();
	}

}	
