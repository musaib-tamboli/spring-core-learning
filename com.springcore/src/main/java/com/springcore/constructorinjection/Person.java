package com.springcore.constructorinjection;

import java.util.List;

public class Person {
private String name;
private int personId;
private Certificate certi;
private List<String> list;
public Person(String name, int personId, Certificate certi,List<String> list) {
	this.name = name;
	this.personId = personId;
	this.certi = certi;
	this.list=list;
}

@Override
public String toString() {
	return this.name+" : "+this.personId+"{ "+this.certi.name+" }"+this.list;
}



}
