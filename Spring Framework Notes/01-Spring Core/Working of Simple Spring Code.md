#### App.java
```java
package com.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        
        // Pass only the filename because it's directly inside src/main/resources
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        
        // Fetch the bean
        Student student1 = (Student) context.getBean("student1");
        Student student2 = (Student) context.getBean("student2");

        // Print the result
        System.out.println(student1);
        System.out.println(student2);
    }
}

```
#### Student.java
```java
package com.springcore;
 

public class Student {

private int studentId;

private String studentName;

private String studentAddress;

public int getStudentId() {

return studentId;

}

public void setStudentId(int studentId) {

this.studentId = studentId;

}

public String getStudentName() {

return studentName;

}

public void setStudentName(String studentName) {

this.studentName = studentName;

}

public String getStudentAddress() {

return studentAddress;

}

public void setStudentAddress(String studentAddress) {

this.studentAddress = studentAddress;

}

public Student(int studentId, String studentName, String studentAddress) {

super();

this.studentId = studentId;

this.studentName = studentName;

this.studentAddress = studentAddress;

}

public Student() {

super();

// TODO Auto-generated constructor stub

}

@Override

public String toString() {

return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAddress=" + studentAddress

+ "]";

} 

}
```

#### Config.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"

xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

xmlns:p="http://www.springframework.org/schema/p"

xsi:schemaLocation="http://www.springframework.org/schema/beans

https://www.springframework.org/schema/beans/spring-beans.xsd">

  

<bean name="student1" class="com.springcore.Student">

<property name="studentId" value="25333" />

<property name="studentName" value="Musaib" />

<property name="studentAddress" value="Sangli" />

</bean>

<bean name="student2" class="com.springcore.Student" p:studentId="2534" p:studentName="Asad" p:studentAddress="Sangli"/>

</beans>
```
####  This is how the Spring 

![[Spring-Working.jpg]]

This code implements several core concepts of the **Spring Framework**, with the primary focus being **Dependency Injection (DI)** via **Setter Injection**.

Here is the breakdown of the exact concepts running under the hood:

### 1. Inversion of Control (IoC)


Instead of you manually creating the `Student` object in your Java code using the `new` keyword (e.g., `Student s = new Student();`), you have handed over the control of object creation and lifecycle management to the **Spring [[IoC (Inversion of Control)| IoC]] Container** (`ClassPathXmlApplicationContext`).

### 2. Dependency Injection ([[Dependency Injection |DI]]) — Specifically *Setter Injection*

Dependency Injection is the practice of passing required data or dependencies into an object. In your code, this is achieved using **Setter Injection**:

* **How it works:** Spring looks at your `config.xml` file, instantiates the `Student` object using its default no-arg constructor (`public Student()`), and then immediately populates the fields by calling the class's **setter methods** (`setStudentId()`, `setStudentName()`, `setStudentAddress()`).

### 3. XML-Based Bean Configuration

You are using a traditional Spring configuration method where metadata is provided to the IoC container via an external XML file (`config.xml`). Within this, two variations of bean definition are shown:

* **Standard Properties:** Used in `student1` via the `<property>` tag.
* **p-namespace Shortcut:** Used in `student2` via `p:studentId="..."`. The **p-namespace** is a cleaner, shorter alternative syntax to the standard `<property>` tags, reducing XML verbosity.

### 4. Bean Factory / Application Context (Container Management)

By using `ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");`, you are initializing the advanced Spring container. This container parses the XML, eagerly instantiates the beans, holds them in a registry, and provides them to your application whenever you call `context.getBean()`.