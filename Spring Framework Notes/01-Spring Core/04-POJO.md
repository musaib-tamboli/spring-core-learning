# 📘 POJO (Plain Old Java Object)

> [!IMPORTANT]  
> **POJO is one of the first concepts you should understand before learning Spring Beans and Dependency Injection.**
> 
> Almost every Spring Bean starts as a **POJO**.

---

# 📖 1. Introduction

## What is a POJO?

A **POJO (Plain Old Java Object)** is a **simple Java class** that is **not dependent on any special framework or library**.

It is just a normal Java class that contains:

- Fields (variables)
    
- Constructors
    
- Getters and Setters
    
- Business methods
    

A POJO does **not** need to extend any special class or implement any special interface.

---

## Why was POJO introduced?

Before Spring, technologies like **Enterprise JavaBeans (EJB)** required classes to extend or implement framework-specific classes and interfaces.

Example (Old EJB style):

```java
public class EmployeeBean implements SessionBean {
    // Framework-specific code
}
```

This made your business logic tightly coupled to the framework.

POJOs solved this by allowing developers to write **plain Java classes** that could later be managed by frameworks like Spring.

---

## Why do companies use POJOs?

- Easier to write and understand
    
- Easy to test (Unit Testing)
    
- Reusable
    
- Framework-independent
    
- Better maintainability
    
- Supports loose coupling
    

---

# 🏠 2. Real-Life Analogy

Imagine a **student**.

A student has:

- Name
    
- Roll Number
    
- Branch
    
- Semester
    

The student simply stores information and performs simple actions.

Similarly, a POJO simply stores data and contains business methods.

```text
Student

+----------------------+
| Name                 |
| Roll Number          |
| Branch               |
| Semester             |
+----------------------+
```

No extra framework dependency.

---

# 📚 3. Definition

### Simple Definition

A POJO is a normal Java class that is **not tied to any framework**.

---

### Interview Definition

> A POJO (Plain Old Java Object) is a simple Java class that does not extend any framework class or implement any special framework interface. It contains fields, constructors, getters, setters, and business methods.

---

### One-Line Definition

> **POJO = Simple Java Class**

---

# ❓ 4. Why Do We Need POJO?

Without POJOs:

- Code depends on frameworks
    
- Difficult to reuse
    
- Hard to test
    
- Hard to maintain
    

With POJOs:

- Independent code
    
- Easy testing
    
- Easy maintenance
    
- Framework flexibility
    

---

# ⚙️ 5. Structure of a POJO

```text
POJO Class
│
├── Private Variables
├── Default Constructor
├── Parameterized Constructor (Optional)
├── Getters
├── Setters
├── Business Methods
└── toString() (Optional)
```

---

# 💻 6. Basic POJO Example

```java
public class Student {

    private int id;
    private String name;

    // Default Constructor
    public Student() {
    }

    // Parameterized Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter
    public int getId() {
        return id;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    // Business Method
    public void display() {
        System.out.println(id + " " + name);
    }
}
```

---

# 📝 Line-by-Line Explanation

```java
public class Student
```

Creates a normal Java class named `Student`.

---

```java
private int id;
```

Stores the student's ID.

`private` means the variable cannot be accessed directly from outside the class.

---

```java
private String name;
```

Stores the student's name.

---

```java
public Student() {}
```

Default constructor.

Called when creating an object without arguments.

---

```java
public Student(int id, String name)
```

Parameterized constructor.

Used to initialize values during object creation.

---

```java
public int getId()
```

Returns the value of `id`.

---

```java
public void setId(int id)
```

Updates the value of `id`.

---

```java
display()
```

A simple business method that prints the student's details.

---

# 🖼️ Memory Representation

```text
Student Object

+---------------------+
| id   = 101          |
| name = "Rahul"      |
+---------------------+
```

---

# 🔄 How Spring Uses a POJO

Without Spring:

```java
Student student = new Student();
student.setId(101);
student.setName("Rahul");
```

Developer creates the object manually.

---

With Spring:

```java
@Component
public class Student {

}
```

Spring creates and manages the object automatically.

```text
Developer
      │
      ▼
Spring Container
      │
Creates Student Object
      │
Stores as Bean
```

> [!TIP]  
> Every **Spring Bean** is based on a **POJO**, but **not every POJO is a Spring Bean**. A POJO becomes a Spring Bean only when it is registered with the Spring Container (for example, using `@Component`, `@Bean`, or XML configuration).

---

# 📊 POJO vs JavaBean vs Spring Bean

|Feature|POJO|JavaBean|Spring Bean|
|---|---|---|---|
|Simple Java Class|✅|✅|✅|
|No Framework Dependency|✅|✅|❌ (Managed by Spring)|
|Default Constructor|Optional|✅ Required|Usually Required (or constructor injection)|
|Getters & Setters|Optional|✅ Required|Optional|
|Serializable|Optional|Usually Yes|Optional|
|Managed by Spring|❌|❌|✅|

---

# 📁 Example in a Spring Project

```text
src
└── main
    └── java
        └── com
            └── example
                ├── controller
                ├── service
                ├── repository
                └── model
                    └── Student.java   ← POJO
```

The `Student` class represents data. It may later become an entity or a Spring-managed bean, depending on how it is used.

---

# ✅ Advantages

- Simple to create
    
- Easy to understand
    
- Framework independent
    
- Easy to test
    
- Easy to reuse
    
- Promotes clean code
    

---

# ❌ Common Mistakes

- ❌ Thinking every POJO is automatically a Spring Bean.
    
- ❌ Extending framework-specific classes unnecessarily.
    
- ❌ Making all fields `public` instead of using encapsulation.
    
- ❌ Forgetting constructors or access methods when needed.
    

---

# 💼 Interview Questions

### 1. What is a POJO?

**Answer:** A POJO is a simple Java class that is not dependent on any framework. It contains fields, constructors, getters, setters, and business methods.

---

### 2. Is every POJO a Spring Bean?

**Answer:** No. A POJO becomes a Spring Bean only when it is registered with the Spring Container.

---

### 3. Can a POJO contain methods?

**Answer:** Yes. A POJO can contain constructors, getters, setters, and business methods.

---

### 4. Does a POJO need to implement any interface?

**Answer:** No. A POJO does not need to implement any special interface or extend any special class.

---

# 📝 Quick Revision

- ✅ POJO = Plain Old Java Object
    
- ✅ Simple Java class
    
- ✅ No framework dependency
    
- ✅ Can have variables, constructors, getters, setters, and methods
    
- ✅ Easy to test and maintain
    
- ✅ Foundation for Spring Beans
    

---

# 🧠 Mnemonic

Remember **POJO** as:

- **P** → Plain
    
- **O** → Old
    
- **J** → Java
    
- **O** → Object
    

Or simply:

> **POJO = "Plain Java Class"**

---

# 🔗 Related Topics (Obsidian)

- [[Spring Bean]]
    
- [[IoC Container]]
    
- [[Dependency Injection]]
    
- [[ApplicationContext]]
    
- [[Bean Lifecycle]]
    
- [[@Component]]
    

---

# 🏷️ Tags

`#Spring` `#SpringCore` `#POJO` `#Java` `#Interview` `#CampusPlacement`

## 🧪 Concept Check

1. Why is a POJO called a "Plain Old Java Object"?
    
2. Can a POJO exist without the Spring Framework?
    
3. What is the difference between a POJO and a Spring Bean?
    
4. Why are POJOs easier to test than framework-dependent classes?
    
5. What changes are needed to turn a POJO into a Spring-managed Bean?