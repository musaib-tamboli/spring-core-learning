package com.springcore.constructorinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.constructorinjection.Person;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("ciconfig.xml");
		
		Person p = (Person) context.getBean("person");
		System.out.println(p);
		
		Addition a = (Addition) context.getBean("addition");
//		System.out.println(a);
		a.sum();

	}

}
