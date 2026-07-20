# 🏛️ Spring Framework Architecture (Part 1 - Foundation)

> [!IMPORTANT]
> **Prerequisite:** Before learning **IoC Container**, **Dependency Injection**, and **Spring Bean**, you **must understand Spring Architecture**. This topic explains **how Spring works internally**.

**Suggested Note Name:** `02-Spring Framework Architecture.md`

**Related Notes:** [[Introduction To Spring Framework]] | [[Spring Framework Modules]] | [[IoC (Inversion of Control)]]

---

# 📖 1. Introduction

## What is Spring Framework Architecture?

Spring Architecture is the **overall design of the Spring Framework** that shows how different Spring modules work together to build Java applications.

It acts like a **blueprint** that explains:

* Which module does what?
* How modules communicate?
* How Spring creates and manages objects?
* How requests travel inside a Spring application?

---

## Why was it introduced?

Before Spring:

* Java Enterprise applications (J2EE) were difficult to build.
* Developers had to write thousands of lines of configuration.
* Objects had to be created manually using `new`.
* Tight coupling made applications difficult to maintain.

Spring solved these problems by providing:

* IoC Container
* Dependency Injection
* Modular architecture
* Easy configuration
* Better maintainability

---

## Why do companies use Spring Architecture?

Companies like:

* Netflix
* Amazon
* Google
* Adobe
* Paytm
* Flipkart

use Spring because it provides:

* Clean architecture
* Loose coupling
* Scalability
* Security
* Easy testing
* Faster development

---

> [!TIP]
> **Interview Question**
>
> **Q:** What is Spring Framework Architecture?
>
> **Answer:**
>
> Spring Framework Architecture is the collection of different Spring modules that work together to develop enterprise Java applications.

---

# 🏠 2. Real Life Analogy

Imagine you are building a **shopping mall**.

```text
Customer
      │
      ▼
Security Gate
      │
      ▼
Reception
      │
      ▼
Different Shops
```

Each shop has its own responsibility.

Example:

```text
Food Shop
Clothing Shop
Movie Theatre
Medical Store
Parking
```

Each performs a different task.

Similarly,

Spring Framework contains different modules.

```text
Spring Core
Spring Beans
Spring Context
Spring AOP
Spring JDBC
Spring MVC
Spring Security
Spring Boot
```

Each module has its own responsibility.

Together they form the Spring Framework.

---

# 📘 3. Definition

### Simple Definition

Spring Architecture is the structure of different Spring modules working together.

---

### Interview Definition

Spring Framework Architecture is a layered architecture consisting of multiple modules such as Core, Beans, Context, AOP, Data Access, Web, Test, and others that together simplify enterprise application development.

---

### One-Line Definition

> Spring Architecture is the organization of Spring modules and the way they interact.

---

# ❓ 4. Why Do We Need Spring Architecture?

## Without Spring

Suppose we are developing an Online Shopping website.

We need:

* Database connection
* Transactions
* Security
* Logging
* REST APIs
* Dependency Injection
* Object Management

Without Spring we write everything manually.

```text
Developer

↓

Creates Object

↓

Database Connection

↓

Transaction

↓

Exception Handling

↓

Security

↓

Logging
```

Thousands of lines of code.

Hard to maintain.

---

## With Spring

Spring provides ready-made modules.

```text
Developer

↓

Uses Spring Modules

↓

Spring does the work

↓

Application Ready
```

Much easier.

---

# ⚙️ 5. High-Level Spring Architecture

```text
                   Spring Framework
                          │
 ┌────────────────────────┼─────────────────────────┐
 │                        │                         │
 ▼                        ▼                         ▼
 Core Container      Data Access              Web Layer
 │                        │                         │
 │                        │                         │
 ▼                        ▼                         ▼
 Beans                JDBC                     Spring MVC
 Context              ORM                      WebSocket
 Expression           Transactions             REST
```

Additional modules:

```text
AOP

Security

Testing

Messaging
```

---

# 🧠 6. Complete Spring Architecture

```text
                    SPRING FRAMEWORK
────────────────────────────────────────────────────────────

                Core Container

   ┌──────────────┬─────────────┬─────────────┬─────────────┐
   │ Spring Core  │ Beans       │ Context     │ SpEL        │
   └──────────────┴─────────────┴─────────────┴─────────────┘

────────────────────────────────────────────────────────────

                 AOP & Instrumentation

        AOP
        Aspects
        Instrumentation

────────────────────────────────────────────────────────────

                  Data Access Layer

 JDBC

 ORM

 OXM

 JMS

 Transactions

────────────────────────────────────────────────────────────

                     Web Layer

 Spring MVC

 WebSocket

 Servlet

 REST Support

────────────────────────────────────────────────────────────

                     Test Module

 JUnit

 Mockito

 Spring Test
```

---

# 🏗️ 7. Layer-wise Explanation

## 1️⃣ Core Container

This is the **heart** of Spring.

It contains:

* Spring Core
* Beans
* Context
* SpEL

Without it,

Spring cannot work.

---

### Responsibilities

* Creates Objects
* Manages Beans
* Performs Dependency Injection
* Reads Configuration
* Manages Bean Lifecycle

---

> [!IMPORTANT]
> **Remember:**
>
> Everything in Spring starts from the **Core Container**.

---

## 2️⃣ AOP Layer

AOP means:

**Aspect Oriented Programming**

Used for:

* Logging
* Security
* Transactions
* Exception Handling

without modifying business code.

---

## 3️⃣ Data Access Layer

Provides support for:

* JDBC
* Hibernate (ORM)
* JPA
* Transactions

Instead of writing complex database code,

Spring simplifies everything.

---

## 4️⃣ Web Layer

Responsible for:

* HTTP Requests
* Controllers
* REST APIs
* MVC

Example:

```text
Browser

↓

Controller

↓

Service

↓

Repository

↓

Database
```

---

## 5️⃣ Test Layer

Helps in:

* Unit Testing
* Integration Testing
* Mock Objects

Used with:

* JUnit
* Mockito

---

# 🎯 Why Learn the Architecture First?

Understanding the architecture helps you see **where each concept fits**.

```text
Spring Framework
        │
        ▼
Spring Architecture
        │
        ▼
Core Container
        │
        ▼
IoC Container
        │
        ▼
Beans
        │
        ▼
Dependency Injection
        │
        ▼
Bean Lifecycle
        │
        ▼
Autowiring
```

Everything you are learning in Spring Core belongs mainly to the **Core Container**.

---

# 📝 Revision Checklist

* [ ] I know what Spring Architecture is.
* [ ] I understand why Spring uses modules.
* [ ] I can name the major layers.
* [ ] I know the role of the Core Container.
* [ ] I understand how the modules work together.

---

> [!INTERVIEW]
> **Most Asked Questions**
>
> 1. What is Spring Architecture?
> 2. Why is Spring modular?
> 3. What are the layers of Spring Framework?
> 4. Which is the most important module in Spring?
> 5. What is the role of the Core Container?

---

# 🧠 Memory Trick

Remember the acronym:

**C A D W T**

* **C** → Core Container
* **A** → AOP
* **D** → Data Access
* **W** → Web
* **T** → Test

Think:

> **"Cool Architects Design Wonderful Towers."**

---

# 🔗 Next Topic

➡️ **Part 2: Core Container Architecture**

We'll study each Core Container module in depth:

1. Spring Core
2. Spring Beans
3. Spring Context
4. Spring Expression Language (SpEL)

These four modules are the foundation of everything you've learned so far (IoC, Dependency Injection, Bean Lifecycle, etc.).

---

**Tags:**
#Spring #SpringFramework #SpringArchitecture #SpringCore #Java #Interview #Obsidian


---

# 🏛️ Spring Framework Architecture (Part 2 - Core Container Architecture)

> [!IMPORTANT]
> **Core Container** is the **heart ❤️ of the Spring Framework**. Every Spring application starts from here. If you understand the Core Container, concepts like **IoC**, **Dependency Injection**, **Bean Lifecycle**, **Autowiring**, and **ApplicationContext** become much easier.

**Suggested Note Name:** `03-Core Container Architecture.md`

**Related Notes:** [[Spring Framework Architecture]] | [[IoC (Inversion of Control)]] | [[Dependency Injection]] | [[Spring Bean Lifecycle]]

---

# 📖 1. Introduction

## What is Core Container?

The **Core Container** is the most important part of Spring.

It is responsible for:

* Creating Java objects (**Beans**)
* Managing those objects
* Injecting dependencies
* Configuring beans
* Managing bean lifecycle

Without the Core Container, Spring cannot work.

---

## Why was it introduced?

Before Spring:

```java
Student student = new Student();
Address address = new Address();
student.setAddress(address);
```

The developer had to:

* Create every object manually.
* Manage dependencies.
* Configure everything.

For large projects, this became difficult.

Spring introduced the **Core Container** to automate these tasks.

---

## Real-Life Analogy 🏢

Imagine a **Hotel Manager**.

### Without Manager

```text
Guest

↓

Looks for Room

↓

Looks for Food

↓

Looks for Staff

↓

Manages Everything Himself
```

Lots of work.

---

### With Manager

```text
Guest

↓

Manager

↓

Assign Room

↓

Arrange Food

↓

Call Staff

↓

Everything Ready
```

The guest only asks the manager.

Similarly,

```text
Developer

↓

Spring Container

↓

Creates Objects

↓

Connects Objects

↓

Application Ready
```

The developer doesn't manage objects manually.

---

# 🎯 What Does the Core Container Do?

The Core Container performs five main jobs.

```text
Creates Beans

↓

Stores Beans

↓

Injects Dependencies

↓

Manages Lifecycle

↓

Provides Beans When Needed
```

---

# 🧩 Modules Inside the Core Container

The Core Container has **4 important modules**.

```text
              Core Container
                     │
     ┌───────────────┼───────────────┐
     │               │               │
     ▼               ▼               ▼
 Spring Core      Spring Beans    Spring Context
                     │
                     ▼
                    SpEL
```

---

# 1️⃣ Spring Core Module

## What is it?

The Spring Core module provides the basic functionality of Spring.

It contains the **IoC Container**.

---

## Responsibilities

* Creates objects
* Manages objects
* Injects dependencies
* Reads configuration

---

### Real-Life Example

Imagine electricity in a house.

Without electricity,

nothing works.

Similarly,

Without Spring Core,

nothing works in Spring.

---

### Internal Working

```text
Application Starts

↓

Reads Configuration

↓

Creates IoC Container

↓

Creates Beans

↓

Injects Dependencies

↓

Application Ready
```

---

### Example

```java
ApplicationContext context =
new ClassPathXmlApplicationContext("config.xml");
```

#### Explanation

`ApplicationContext`

➡ Interface of Spring.

---

`ClassPathXmlApplicationContext`

➡ Reads XML configuration.

---

`config.xml`

➡ Contains bean definitions.

---

# 2️⃣ Spring Beans Module

## What is a Bean?

A Bean is simply an object managed by Spring.

Instead of

```java
Student s = new Student();
```

Spring creates it.

```text
Spring Container

↓

Creates Student Object

↓

Stores Object

↓

Returns When Needed
```

---

## Responsibilities

* Bean creation
* Bean configuration
* Bean initialization
* Bean destruction

---

### Example

```xml
<bean id="student"
      class="com.spring.Student"/>
```

Spring creates:

```java
Student student = new Student();
```

internally.

---

### BeanFactory

The Beans module contains

```text
BeanFactory
```

It is the smallest IoC container.

Responsibilities:

* Creates beans
* Stores beans
* Returns beans

---

> [!TIP]
> **Interview Question**
>
> **Q:** Which interface is responsible for bean management?
>
> **Answer:** `BeanFactory`

---

# 3️⃣ Spring Context Module

## What is Context?

Context means **Application Context**.

It is an advanced version of `BeanFactory`.

---

### Real-Life Example

BeanFactory is like:

A normal calculator.

ApplicationContext is like:

A scientific calculator.

Both calculate,

but one has more features.

---

### ApplicationContext Provides

* Bean management
* Dependency Injection
* Event handling
* Internationalization (multiple languages)
* Resource loading

---

### Example

```java
ApplicationContext context =
new ClassPathXmlApplicationContext("config.xml");
```

---

### Internal Working

```text
Application Starts

↓

ApplicationContext Created

↓

Reads XML

↓

Creates Beans

↓

Injects Dependencies

↓

Stores Beans

↓

Application Ready
```

---

# BeanFactory vs ApplicationContext

| Feature              | BeanFactory | ApplicationContext |
| -------------------- | ----------- | ------------------ |
| Basic Container      | ✅           | ✅                  |
| Dependency Injection | ✅           | ✅                  |
| Events               | ❌           | ✅                  |
| Internationalization | ❌           | ✅                  |
| Annotation Support   | Limited     | Full               |
| Enterprise Projects  | ❌           | ✅                  |
| Most Used            | ❌           | ✅                  |

---

> [!IMPORTANT]
> Nowadays, **ApplicationContext** is preferred over **BeanFactory** in almost all Spring applications because it offers many additional features.

---

# 4️⃣ Spring Expression Language (SpEL)

## What is SpEL?

SpEL stands for **Spring Expression Language**.

It is used to:

* Read properties
* Perform calculations
* Call methods
* Access object values
* Make decisions in configuration

---

### Example

```java
#{10 + 20}
```

Result:

```text
30
```

---

Another example:

```java
#{student.name}
```

Gets the value of:

```java
student.getName();
```

---

> [!TIP]
> You will study **SpEL** in detail later. For now, remember that it lets Spring evaluate expressions inside configuration.

---

# ⚙️ Complete Internal Working

```text
Developer

↓

Writes POJO

↓

Creates XML

↓

Starts Application

↓

ApplicationContext

↓

Reads XML

↓

Core Container

↓

Creates Bean

↓

Injects Dependencies

↓

Stores Bean

↓

Returns Bean

↓

Application Runs
```

---

# 🧠 Memory Diagram

```text
Memory

+--------------------------------------+

ApplicationContext

+--------------------------------------+

studentBean -------> Student Object

employeeBean -----> Employee Object

addressBean ------> Address Object

+--------------------------------------+
```

The container holds references to your managed objects (beans) and provides them whenever requested.

---

# 🔄 Core Container Flow

```text
XML

↓

Bean Definition

↓

Core Module

↓

BeanFactory

↓

ApplicationContext

↓

Bean Creation

↓

Dependency Injection

↓

Bean Lifecycle

↓

Application Ready
```

---

# 📊 Core Container Modules Comparison

| Module  | Responsibility                             | Most Important Class / Interface |
| ------- | ------------------------------------------ | -------------------------------- |
| Core    | IoC and Dependency Injection               | `BeanFactory`                    |
| Beans   | Bean creation and lifecycle                | `BeanDefinition` / `BeanFactory` |
| Context | Advanced container and enterprise features | `ApplicationContext`             |
| SpEL    | Expression evaluation                      | `ExpressionParser`               |

---

# 💼 Real Project Example

Imagine an **Online Banking System**.

```text
Customer

↓

Login Controller

↓

Authentication Service

↓

User Repository

↓

Database
```

Spring Core Container:

* Creates all these objects.
* Connects them together.
* Manages their lifecycle.
* Makes sure only one shared bean is used where appropriate.

The developer focuses on business logic instead of object creation.

---

# 🚫 Common Beginner Mistakes

> [!WARNING]
>
> * Thinking `BeanFactory` and `ApplicationContext` are completely different. (`ApplicationContext` builds on `BeanFactory`.)
> * Believing Spring automatically manages every object. (Only registered **beans** are managed.)
> * Confusing the **Core Module** with the **Core Container**.
> * Assuming SpEL is Java code. (It has its own expression syntax.)

---

# 🎯 Frequently Asked Interview Questions

### Beginner

1. What is the Core Container?
2. Why is it called the heart of Spring?
3. What are the four modules of the Core Container?
4. What is a Spring Bean?
5. What is `ApplicationContext`?

### Intermediate

6. Difference between `BeanFactory` and `ApplicationContext`?
7. Why is `ApplicationContext` preferred?
8. What is SpEL?
9. How does the Core Container create beans?
10. What is the relationship between IoC and the Core Container?

---

# 📝 Revision Checklist

* [ ] I know what the Core Container is.
* [ ] I know the four Core Container modules.
* [ ] I understand the role of Spring Core.
* [ ] I understand what the Beans module does.
* [ ] I know why `ApplicationContext` is preferred.
* [ ] I know the purpose of SpEL.

---

# 📌 Cheat Sheet

| Module         | Purpose                               |
| -------------- | ------------------------------------- |
| Spring Core    | IoC and Dependency Injection          |
| Spring Beans   | Bean creation and lifecycle           |
| Spring Context | Advanced IoC container                |
| SpEL           | Expression language for configuration |

**Remember the order:**

```text
Core
   ↓
Beans
   ↓
Context
   ↓
SpEL
```

**Mnemonic:** **"Cool Boys Cook Soup"**

* **C** → Core
* **B** → Beans
* **C** → Context
* **S** → SpEL

---

# 🔗 Next Topic

➡️ **Spring Framework Modules (Deep Dive)**

In the next note, we'll explore **every major Spring module**—Core, AOP, JDBC, ORM, Web MVC, Test, Messaging, Security—and understand where each is used in real-world applications.

---

**Tags:**
#Spring #SpringCore #SpringArchitecture #CoreContainer #BeanFactory #ApplicationContext #SpEL #Java #Interview
