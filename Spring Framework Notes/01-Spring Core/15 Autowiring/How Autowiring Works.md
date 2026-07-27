Let's trace exactly **which file, class, method, and setter Spring calls internally**.

---

# Project Structure

```text
src
│
├── java
│   └── com.springcore.autowire
│
│       ├── Engine.java
│       ├── Car.java
│       └── Test.java
│
└── resources
    └── autowireconfig.xml
```

---

# Engine.java

```java
public class Engine {

    public Engine() {
        System.out.println("Engine Object Created");
    }
}
```

---

# Car.java

```java
public class Car {

    private Engine engine;

    public Car() {
        System.out.println("Car Object Created");
    }

    public void setEngine(Engine engine) {
        System.out.println("Setter Injection Called");
        this.engine = engine;
    }

    public void start() {
        System.out.println("Car Started");
    }
}
```

---

# autowireconfig.xml

```xml
<bean id="engine"
      class="com.springcore.autowire.Engine"/>

<bean id="car"
      class="com.springcore.autowire.Car"
      autowire="byName"/>
```

---

# Test.java

```java
ApplicationContext context =
new ClassPathXmlApplicationContext("autowireconfig.xml");

Car car = context.getBean("car", Car.class);

car.start();
```

---

# Internal Working (Step-by-Step)

## Step 1

The JVM starts

```text
Test.java
```

Execution begins here.

```java
public static void main(String[] args)
```

↓

---

## Step 2

This line executes

```java
ApplicationContext context =
new ClassPathXmlApplicationContext("autowireconfig.xml");
```

Spring creates the IoC Container.

```text
Test.java
        │
        ▼
ClassPathXmlApplicationContext
```

---

## Step 3

Spring loads

```text
autowireconfig.xml
```

It reads

```xml
<bean id="engine".../>
```

and

```xml
<bean id="car".../>
```

---

## Step 4

Spring creates the **Engine Bean**

It sees

```xml
class="com.springcore.autowire.Engine"
```

Internally Spring does something similar to:

```java
Engine engine = new Engine();
```

So

```java
Engine()
```

constructor executes.

Console

```text
Engine Object Created
```

Memory

```text
Engine Bean

+------------+
| Engine     |
+------------+
```

---

## Step 5

Spring creates the **Car Bean**

It reads

```xml
class="com.springcore.autowire.Car"
```

Internally

```java
Car car = new Car();
```

Constructor executes

```java
Car()
```

Console

```text
Car Object Created
```

Memory

```text
Car Bean

+----------------+
| engine = null  |
+----------------+
```

Notice

```text
engine is still null
```

because injection has not happened yet.

---

## Step 6

Spring notices

```xml
autowire="byName"
```

Now Spring thinks

> "I need to inject dependencies automatically."

---

## Step 7

Spring inspects

```java
Car.class
```

using Java Reflection.

It checks all properties.

Finds

```java
private Engine engine;
```

and

```java
setEngine()
```

Internally it discovers

```text
Property Name

engine
```

---

## Step 8

Spring searches all beans.

Available beans are

```text
engine
car
```

It compares

```text
Property Name

engine
```

with

```text
Bean ID

engine
```

Match found ✅

---

## Step 9

Spring calls

```java
car.setEngine(engine);
```

Exactly this method

```java
public void setEngine(Engine engine)
```

gets executed.

Console

```text
Setter Injection Called
```

Now

```java
this.engine = engine;
```

stores the object reference.

Memory

```text
Car Object

+-------------------------+
| engine -----------------|------+
+-------------------------+      |
                                 |
                                 ▼
                         +---------------+
                         | Engine Object |
                         +---------------+
```

---

## Step 10

Container is fully ready.

Now

```java
Car car = context.getBean("car", Car.class);
```

returns

the already created Car Bean.

Spring does **NOT**

```java
new Car();
```

again.

It simply returns the existing singleton bean.

---

## Step 11

Now

```java
car.start();
```

executes.

Since

```java
engine
```

is already injected,

everything works correctly.

---

# Complete Internal Flow

```text
Test.java
│
│
▼
main()
│
▼
new ClassPathXmlApplicationContext()
│
▼
Read autowireconfig.xml
│
├───────────────┐
│               │
▼               ▼
Create      Create
Engine       Car
Bean         Bean
│               │
│               ▼
│         engine = null
│
└───────────────┐
                │
                ▼
autowire="byName"
                │
                ▼
Inspect Car Class
                │
                ▼
Find setEngine()
                │
                ▼
Search Bean id="engine"
                │
                ▼
Match Found
                │
                ▼
Call

car.setEngine(engine)

                │
                ▼
Dependency Injected
                │
                ▼
context.getBean("car")
                │
                ▼
car.start()
```

---

# Which Methods Are Called?

Execution order:

```text
1. Test.main()

↓

2. ClassPathXmlApplicationContext()

↓

3. Engine()

↓

4. Car()

↓

5. Car.setEngine()

↓

6. context.getBean()

↓

7. Car.start()
```

---

# What Happens Internally in Spring?

Spring internally uses **Java Reflection** to inspect your class.

It effectively performs operations similar to:

```java
Class<?> cls = Car.class;

// Create object
Object obj = cls.getDeclaredConstructor().newInstance();

// Find setter method
Method method = cls.getMethod("setEngine", Engine.class);

// Call setter automatically
method.invoke(obj, engineBean);
```

> [!IMPORTANT]  
> **Spring never writes `car.setEngine(engine)` in its source code for your specific class.**
> 
> Instead, it uses **Reflection** to discover the setter method at runtime and invoke it automatically. This is why Spring can work with any Java class without knowing its methods in advance.

---

## 🎯 Interview Question

**Q:** Does Spring directly call `setEngine()`?

**Answer:**

No. Spring first uses **Reflection** to inspect the `Car` class, finds the `setEngine(Engine)` setter, and then invokes it automatically with the matching bean. This is how dependency injection is performed behind the scenes.

This step-by-step flow is exactly what interviewers expect when they ask, **"Explain how Spring Autowiring works internally."**