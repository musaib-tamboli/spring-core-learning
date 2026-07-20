package com.springcore.referenceinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.referenceinjection.*;
public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("refconfig.xml");
		A a1  = (A) context.getBean("aref");
		System.out.println(a1.getX());
		
		System.out.println(a1.getOb().getY());
		
	}

}
