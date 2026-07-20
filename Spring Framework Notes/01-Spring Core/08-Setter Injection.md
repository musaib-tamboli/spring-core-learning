# 🌱 Setter Injection in Spring Framework

> [!IMPORTANT]
> **Setter Injection** is a type of **Dependency Injection (DI)** where the Spring IoC Container injects values or objects into a bean **by calling its setter methods** after creating the object.

---

# 📖 1. Introduction

## What is Setter Injection?

Setter Injection is a technique where Spring creates an object using the **default constructor** and then injects values or dependencies by calling the corresponding **setter methods**.

Instead of you writing:

```java
Student student = new Student();
student.setStudentId(101);
student.setStudentName("Musaib");
```

Spring performs these setter calls automatically.

---

## Why was it introduced?

Before Spring, developers manually created objects and called every setter.

```java
Student student = new Student();

student.setStudentId(101);
student.setStudentName("Musaib");
student.setStudentAddress("Pune");
```

Problems:

- Lots of repetitive code
- Tight coupling
- Difficult maintenance
- Difficult testing
- Object creation scattered throughout the application

Spring solves this by taking responsibility for object creation and dependency injection.

---

## Why do companies use Setter Injection?

Setter Injection is useful when:

- Dependencies are **optional**
- Values may change after object creation
- Configuration is externalized in XML or properties

---

# 🏠 2. Real-Life Analogy

Imagine buying a new smartphone.

When you first buy it, it's empty.

After turning it on, you configure:

- Wi-Fi
- Wallpaper
- Language
- Fingerprint
- Notifications

The phone already exists.

You are only configuring it afterward.

Setter Injection works exactly like this.

```text
Phone Purchased
        │
        ▼
Phone Created
        │
        ▼
Configure WiFi
        ▼
Configure Language
        ▼
Configure Wallpaper
```

Similarly,

```java
Student student = new Student();

student.setStudentId(101);
student.setStudentName("Musaib");
student.setStudentAddress("Pune");
```

---

# 📘 3. Definition

## Simple Definition

Setter Injection is a Dependency Injection technique where Spring injects dependencies using setter methods.

---

## Interview Definition

> Setter Injection is the process in which the Spring IoC Container creates a bean using the default constructor and injects dependencies by invoking public setter methods.

---

## One-Line Definition

> **Setter Injection = Dependency Injection using Setter Methods**

---

# ❓4. Why Do We Need Setter Injection?

Without Setter Injection

```java
Student student = new Student();

student.setStudentId(101);
student.setStudentName("Musaib");
student.setStudentAddress("Pune");
```

Developer manually calls every setter.

---

With Spring

```xml
<bean id="student"
      class="com.springcore.Student">

    <property name="studentId" value="101"/>
    <property name="studentName" value="Musaib"/>
    <property name="studentAddress" value="Pune"/>

</bean>
```

Spring automatically calls all setter methods.

---

# ⚙️ 5. Working Mechanism

```text
Application Starts
        │
        ▼
Spring Reads XML
        │
        ▼
Creates Object
(Default Constructor)
        │
        ▼
Calls Setter Methods
        │
        ▼
Injects Values
        │
        ▼
Stores Bean
        │
        ▼
Application Ready
```

---

# 🔬 6. Internal Working

Suppose XML contains:

```xml
<bean id="student"
      class="com.springcore.Student">

    <property name="studentId" value="101"/>
    <property name="studentName" value="Musaib"/>
    <property name="studentAddress" value="Pune"/>

</bean>
```

Spring internally performs:

```java
Student student = new Student();

student.setStudentId(101);
student.setStudentName("Musaib");
student.setStudentAddress("Pune");
```

You never write this code.

Spring writes it for you.

---

# 🔄 Complete Flow

```text
XML
 │
 ▼
Spring Container
 │
 ▼
Create Object
 │
 ▼
Default Constructor
 │
 ▼
Call setStudentId()
 │
 ▼
Call setStudentName()
 │
 ▼
Call setStudentAddress()
 │
 ▼
Bean Ready
```

---

# 📝 7. Syntax

## XML

```xml
<bean id="student"
      class="com.springcore.Student">

    <property name="studentId"
              value="101"/>

    <property name="studentName"
              value="Musaib"/>

    <property name="studentAddress"
              value="Pune"/>

</bean>
```

---

## property Tag

```xml
<property
        name="variableName"
        value="value"/>
```

---

### name

Represents the Java property (field).

Example

```java
private String studentName;
```

XML

```xml
name="studentName"
```

Spring searches for

```java
setStudentName(...)
```

---

### value

Actual value to inject.

Example

```xml
value="Musaib"
```

Spring calls

```java
setStudentName("Musaib");
```

---

### ref

Used when injecting another bean.

```xml
<property
        name="certificate"
        ref="certi"/>
```

---

# 💻 8. Complete Example

## Student.java

```java
package com.springcore;

public class Student {

    private int studentId;
    private String studentName;
    private String studentAddress;

    public Student() {
        System.out.println("Default Constructor Called");
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    @Override
    public String toString() {
        return studentId + " "
                + studentName + " "
                + studentAddress;
    }
}
```

---

## config.xml

```xml
<bean id="student"
      class="com.springcore.Student">

    <property name="studentId"
              value="101"/>

    <property name="studentName"
              value="Musaib"/>

    <property name="studentAddress"
              value="Pune"/>

</bean>
```

---

## App.java

```java
ApplicationContext context =
        new ClassPathXmlApplicationContext("config.xml");

Student student =
        context.getBean("student", Student.class);

System.out.println(student);
```

---

## Output

```text
Default Constructor Called

101 Musaib Pune
```

---

# 🧠 Memory Diagram

```text
Heap Memory

Student Object

+----------------------+
| studentId = 101      |
| studentName=Musaib   |
| studentAddress=Pune  |
+----------------------+
```

---

# 🎨 Visual Representation

```text
config.xml

↓

Student Bean

↓

Default Constructor

↓

setStudentId()

↓

setStudentName()

↓

setStudentAddress()

↓

Bean Ready
```

---

# 📌 Important Rules

✅ Default constructor should exist.

✅ Setter methods should be public.

✅ Property name must match Java field.

Example

Field

```java
private String studentName;
```

Setter

```java
setStudentName(...)
```

XML

```xml
<property name="studentName"/>
```

---

# 🔥 Advantages

- Easy to understand
- Flexible
- Good for optional dependencies
- Values can be modified later
- Readable XML
- Easy testing

---

# ❌ Disadvantages

- Object may be partially initialized
- Mandatory dependencies can be forgotten
- More setter methods
- Mutable object

---

# 📊 Setter Injection vs Constructor Injection

| Setter Injection | Constructor Injection |
|------------------|----------------------|
| Uses Setter | Uses Constructor |
| Calls Default Constructor | Calls Parameterized Constructor |
| Optional Dependency | Mandatory Dependency |
| Mutable Object | Immutable Object possible |
| Can change later | Fixed after creation |
| Uses `<property>` | Uses `<constructor-arg>` |

---

# 🏢 Real Project Use Cases

### Banking

Optional:

- Email
- Mobile Number
- Address

Setter Injection is suitable.

---

### E-Commerce

Optional:

- Coupon Code
- Referral Code
- Delivery Instructions

Setter Injection works well.

---

### Hospital

Optional:

- Secondary Phone
- Emergency Contact

Setter Injection is appropriate.

---

# ⚠️ Common Mistakes

### Mistake 1

No Setter Method

```java
private String name;
```

No

```java
setName()
```

Spring throws:

```text
NotWritablePropertyException
```

---

### Mistake 2

Wrong Property Name

```xml
<property
name="studentname"
```

Java

```java
studentName
```

Capitalization matters.

---

### Mistake 3

No Default Constructor

Spring cannot create the object for setter injection.

---

# 🛠️ Debugging Tips

| Error | Reason | Solution |
|--------|--------|----------|
| NotWritablePropertyException | Setter missing | Create setter |
| BeanCreationException | Wrong property name | Check XML |
| Null Value | Property not injected | Verify XML |
| NoSuchMethodException | Default constructor missing | Add default constructor |

---

# 💼 Frequently Asked Interview Questions

### Beginner

### 1. What is Setter Injection?

Dependency Injection through setter methods.

---

### 2. Which XML tag is used?

```xml
<property>
```

---

### 3. Which constructor is required?

Default constructor.

---

### Intermediate

### 4. When should Setter Injection be used?

For optional dependencies.

---

### 5. Which method does Spring call?

Public setter methods.

---

### Advanced

### 6. Why is Constructor Injection generally preferred?

Because it guarantees mandatory dependencies are available when the object is created.

---

### 7. Can Setter Injection inject another bean?

Yes.

```xml
<property
name="certi"
ref="certificate"/>
```

---

# 📝 Revision Checklist

- [ ] I know what Setter Injection is.
- [ ] I know why it uses the default constructor.
- [ ] I understand the `<property>` tag.
- [ ] I know the difference between `value` and `ref`.
- [ ] I know when to use Setter Injection.

---

# ⚡ Cheat Sheet

```text
Setter Injection

↓

Default Constructor

↓

property Tag

↓

value

↓

ref

↓

Setter Method Called

↓

Bean Ready
```

---

# 🧠 Mnemonic

Remember:

**S = Setter = Set Later**

- **Setter → Set Later**
- **Constructor → Complete at Creation**

---

# 📌 Summary

- Setter Injection creates the bean using the default constructor.
- Spring injects values by calling setter methods.
- It uses the `<property>` tag in XML.
- `value` injects primitive/simple values.
- `ref` injects another Spring bean.
- Best suited for optional dependencies.
- Constructor Injection is preferred for mandatory dependencies.

---

# 🔗 Related Topics (Obsidian)

- [[Dependency Injection]]
- [[Injecting Values]]
- [[Injecting Reference Type]]
- [[Injecting Collection Types]]
- [[Constructor Injection]]
- [[Bean Lifecycle]]

---

# 🏷️ Tags

#Spring #SpringCore #SetterInjection #DependencyInjection #IoC #Java #Interview

---

