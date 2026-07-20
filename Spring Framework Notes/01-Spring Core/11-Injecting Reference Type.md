# 🌱 Spring Core - Injecting Reference Type (Bean Reference Injection)

> [!IMPORTANT]  
> **Injecting Reference Type** means **injecting one Spring Bean into another Spring Bean**.
> 
> Instead of injecting simple values like `int` or `String`, we inject **an object (reference) of another class**.

---

# 📖 1. Introduction

## What is Injecting Reference Type?

In Spring, a bean often depends on another bean.

For example:

- A **Student** has an **Address**.
    
- An **Employee** works in a **Department**.
    
- An **Order** belongs to a **Customer**.
    

Instead of manually creating these objects using `new`, Spring creates them and connects them automatically.

---

## Why was it introduced?

Imagine this Java code:

```java
Address address = new Address();

Student student = new Student();

student.setAddress(address);
```

You are responsible for:

- Creating `Address`
    
- Creating `Student`
    
- Connecting both objects
    

In a large project with thousands of objects, this becomes difficult.

Spring solves this by managing object creation and connections.

---

## Why do companies use it?

- Loose coupling
    
- Easy maintenance
    
- Easy testing
    
- Better code organization
    
- Reusable components
    

---

# 🏠 2. Real-Life Analogy

Imagine a **Student**.

A student has:

- Name
    
- Roll Number
    
- Address
    

Here,

**Address is not just a String.**

Address itself contains

- City
    
- State
    
- Pin Code
    

```text
Student

Rahul
│
└──────────────► Address

                 Pune
                 Maharashtra
                 411001
```

Student **has an Address object**.

This is a **Reference Type**.

---

# 📚 3. Definition

## Simple Definition

Injecting Reference Type means injecting one bean into another bean.

---

## Interview Definition

> Reference Injection is a form of Dependency Injection in which one Spring Bean is injected into another Spring Bean using the `ref` attribute or `<ref>` element.

---

## One-Line Definition

> **Reference Injection = Bean inside another Bean**

---

# ❓4. Why Do We Need It?

Without Spring

```java
Address address = new Address();

Student student = new Student();

student.setAddress(address);
```

Problems:

- Too many `new` keywords
    
- Tight coupling
    
- Difficult testing
    
- Difficult maintenance
    

---

With Spring

```xml
<property name="address" ref="addressBean"/>
```

Spring does everything automatically.

---

# ⚙️5. Working Mechanism

```text
Developer
      │
      ▼
Writes Student Bean

Writes Address Bean
      │
      ▼
Spring Reads XML
      │
      ▼
Creates Address Object
      │
      ▼
Creates Student Object
      │
      ▼
Injects Address into Student
      │
      ▼
Application Ready
```

---

# 🔧6. Internal Working

Suppose XML contains

```xml
<property name="address" ref="addressBean"/>
```

Spring performs internally

```java
Address address = new Address();

Student student = new Student();

student.setAddress(address);
```

Notice

You never wrote

```java
new Address();
```

Spring did.

---

# 📂 Project Structure

```text
SpringCoreProject

src
│
├── Address.java
├── Student.java
├── App.java
│
└── resources
      │
      └── config.xml
```

---

# 📝 Step 1 : Address Class

```java
package com.springcore;

public class Address {

    private String city;
    private String state;

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return city + " " + state;
    }

}
```

---

# 📝 Step 2 : Student Class

Instead of

```java
private String address;
```

We'll write

```java
private Address address;
```

Complete class

```java
package com.springcore;

public class Student {

    private int studentId;

    private String studentName;

    private Address address;

    public Student() {
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return studentId + " "
                + studentName + " "
                + address;
    }

}
```

---

# 📝 Step 3 : XML Configuration

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans
xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

xsi:schemaLocation="
http://www.springframework.org/schema/beans
https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Address Bean -->

    <bean id="addressBean"
          class="com.springcore.Address">

        <property
            name="city"
            value="Pune"/>

        <property
            name="state"
            value="Maharashtra"/>

    </bean>

    <!-- Student Bean -->

    <bean id="studentBean"
          class="com.springcore.Student">

        <property
            name="studentId"
            value="101"/>

        <property
            name="studentName"
            value="Rahul"/>

        <!-- Reference Injection -->

        <property
            name="address"
            ref="addressBean"/>

    </bean>

</beans>
```

---

# ⭐ Most Important Line

```xml
<property
      name="address"
      ref="addressBean"/>
```

Meaning

```text
Student.address

↓

Use

↓

addressBean
```

Here,

`ref` means

> **Use another Spring Bean.**

---

# 📝 Step 4 : App.java

```java
ApplicationContext context =
        new ClassPathXmlApplicationContext("config.xml");

Student student =
        context.getBean("studentBean",
                Student.class);

System.out.println(student);
```

---

# Output

```text
101 Rahul Pune Maharashtra
```

---

# 🖼️ ASCII Diagram

```text
               Spring Container
               ─────────────────

         +-------------------------+
         |     addressBean         |
         |-------------------------|
         | city = Pune             |
         | state = Maharashtra     |
         +-----------▲-------------+
                     │ ref
                     │
         +-----------┴-------------+
         |     studentBean         |
         |-------------------------|
         | id = 101                |
         | name = Rahul            |
         | address = addressBean ──┘
         +-------------------------+
```

---

# 🧠 Memory Representation

```text
Heap Memory

Student Object
+----------------------------+
| id = 101                   |
| name = Rahul               |
| address -------------------+------+
+----------------------------+      |
                                    |
                                    ▼
                          Address Object
                    +----------------------+
                    | city = Pune          |
                    | state = Maharashtra  |
                    +----------------------+
```

The `address` field stores a **reference** (memory address) to the `Address` object, not a copy of the object.

---

# 🔄 Internal Flow

```text
config.xml
      │
      ▼
Create Address Bean
      │
      ▼
Store Address Bean
      │
      ▼
Create Student Bean
      │
      ▼
Find ref="addressBean"
      │
      ▼
Inject Address Object
      │
      ▼
Student Ready
```

---

# 🆚 Value Injection vs Reference Injection

|Feature|Value Injection|Reference Injection|
|---|---|---|
|Injects|Primitive values (`int`, `String`, etc.)|Another Bean (Object)|
|XML Attribute|`value`|`ref`|
|Example|`value="101"`|`ref="addressBean"`|
|Data Type|Primitive / Wrapper / String|Custom Java Class|

---

# ✅ Advantages

- Loose coupling
    
- Reusable beans
    
- Cleaner code
    
- Easy maintenance
    
- Easy testing
    
- Spring manages dependencies
    

---

# ❌ Common Mistakes

### 1. Using `value` instead of `ref`

❌ Wrong

```xml
<property name="address"
          value="addressBean"/>
```

This treats `"addressBean"` as a **String**, not an object.

---

✅ Correct

```xml
<property name="address"
          ref="addressBean"/>
```

---

### 2. Bean ID mismatch

❌ Wrong

```xml
<bean id="address1" .../>

<property
      name="address"
      ref="addressBean"/>
```

`addressBean` doesn't exist.

---

### 3. Setter Missing

If `Student` doesn't have:

```java
public void setAddress(Address address)
```

Spring cannot inject the bean and will throw an exception.

---

> [!WARNING]  
> The `name` attribute in `<property>` must match the Java property name (`address`), and the `ref` value must match an existing bean `id`.

---

# 💼 Real Project Examples

### Banking

```text
Customer
      │
      ▼
Address
```

---

### E-Commerce

```text
Order
      │
      ▼
Customer
```

---

### Hospital

```text
Doctor
      │
      ▼
Department
```

---

### College

```text
Student
      │
      ▼
Course
```

---

# 🎯 Interview Questions

### Q1. What is Reference Injection?

**Answer:** Reference Injection is the process of injecting one Spring Bean into another Spring Bean using the `ref` attribute.

---

### Q2. What is the difference between `value` and `ref`?

|value|ref|
|---|---|
|Injects primitive values|Injects another bean|
|Used for `String`, `int`, etc.|Used for custom objects|

---

### Q3. Can we inject a bean without `new`?

**Answer:** Yes. Spring creates the object and injects it automatically.

---

### Q4. Which method is called during setter-based reference injection?

**Answer:** The setter method for the property, for example:

```java
setAddress(Address address)
```

---

# 📝 Revision Checklist

-  I know what Reference Injection is.
    
-  I understand the difference between `value` and `ref`.
    
-  I can create two beans in XML.
    
-  I know how Spring injects one bean into another.
    
-  I can explain the internal flow in an interview.
    

---

# 🧠 Mnemonic

Remember:

- **V = Value = Variable**
    
- **R = Ref = Reference = Real Object**
    

```text
value → Data

ref → Bean
```

---

# 🔗 Related Topics (Obsidian)

- [[Setter Injection]]
    
- [[Constructor Injection]]
    
- [[Spring Bean]]
    
- [[IoC Container]]
    
- [[Autowiring]]
    

---

# 🏷️ Tags

#Spring #SpringCore #DependencyInjection #ReferenceInjection #XMLConfiguration #Java #Interview

# ⏭️ Next Topic

**[[Constructor Injection]]** — Learn how Spring injects dependencies by calling a parameterized constructor instead of setter methods.