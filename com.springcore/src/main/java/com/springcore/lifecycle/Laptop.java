package com.springcore.lifecycle;

public class Laptop {
private double price;

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	System.out.println("Setting Price");

	this.price = price;
}

public Laptop() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Laptop [price=" + price + "]";
}

public void init()
{
	System.out.println("Inside Init Method ");
	
}
public void destroy()
{
	System.out.println("Inside Destroy Method ");

}

}
