//package com.springcore.stereotype;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Computer {
//
//    private CPU cpu;
//
//    @Autowired
//    public Computer(CPU cpu) {
//
//        this.cpu = cpu;
//
//        System.out.println("Computer Bean Created");
//    }
//
//    public void start() {
//
//        System.out.println("Computer Started");
//
//        cpu.process();
//
//    }
//
//}