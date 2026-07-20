When your application classes grow beyond storing simple strings and integers, you'll often need to manage groups of items—such as a student enrolled in multiple courses, holding a set of phone numbers, or mapping out a weekly lecture schedule.

In Spring, this is handled through **Collection Type Injection**. Spring provides built-in XML structural tags to inject standard Java collection implementations like `List`, `Set`, `Map`, and `Properties` seamlessly via Setter Injection.

### 1. 📋 The Core Spring Collection Tags

When you are defining a collection property inside your XML configuration, you nest the collection type tags directly inside the standard `<property>` element:

|**XML Tag**|**Java Interface Type**|**Duplicate Handling**|**Order Preserved**|
|---|---|---|---|
|**`<list>`**|`java.util.List`|Allows duplicates|Yes (Insertion Order)|
|**`<set>`**|`java.util.Set`|Removes duplicates|Dependent on implementation|
|**`<map>`**|`java.util.Map`|Overwrites duplicate keys|No|
|**`<props>`**|`java.util.Properties`|Overwrites duplicate keys|String-only key/value mapping|

### 2. 💻 Full Practical Implementation Code

Let's modify our project layout to create an advanced `Employee` class that showcases every single major collection type available in Spring.

#### 1. The Java Class File (`/com.springcore/src/main/java/com/springcore/Employee.java`)

Java

```java
package com.springcore;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Employee {
    private String name;
    private List<String> phones;
    private Set<String> addresses;
    private Map<String, String> courses;
    private Properties props;

    // Mandatory Default Constructor
    public Employee() {
        super();
    }

    // Standard Setters required for Spring Injection
    public void setName(String name) { this.name = name; }
    public void setPhones(List<String> phones) { this.phones = phones; }
    public void setAddresses(Set<String> addresses) { this.addresses = addresses; }
    public void setCourses(Map<String, String> courses) { this.courses = courses; }
    public void setProps(Properties props) { this.props = props; }

    // Standard Getters
    public String getName() { return name; }
    public List<String> getPhones() { return phones; }
    public Set<String> getAddresses() { return addresses; }
    public Map<String, String> getCourses() { return courses; }
    public Properties getProps() { return props; }

    @Override
    public String toString() {
        return "Employee Summary:\n" +
               " -> Name: " + name + "\n" +
               " -> Phone List: " + phones + "\n" +
               " -> Address Set: " + addresses + "\n" +
               " -> Course Map: " + courses + "\n" +
               " -> Properties: " + props;
    }
}
```

#### 2. The Offline-Safe Configuration Mapping (`/com.springcore/src/main/resources/config.xml`)

Using our unblockable, network-free XML structure, here is how you translate those collections into metadata layout items:

XML

```xml

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN"
          "http://www.springframework.org/dtd/spring-beans-2.0.dtd">

<beans>

    <bean id="employee1" class="com.springcore.Employee">
        <!-- 1. Injecting a standard String property -->
        <property name="name" value="Musaib" />

        <!-- 2. Injecting a List (Allows ordered, duplicate values) -->
        <property name="phones">
            <list>
                <value>9876543210</value>
                <value>8888888888</value>
                <value>9876543210</value> <!-- Duplicate values are kept -->
            </list>
        </property>

        <!-- 3. Injecting a Set (Enforces unique values) -->
        <property name="addresses">
            <set>
                <value>Sangli</value>
                <value>Solapur</value>
                <value>Sangli</value> <!-- This duplicate will be automatically removed -->
            </set>
        </property>

        <!-- 4. Injecting a Map (Key-Value storage blocks) -->
        <property name="courses">
            <map>
                <entry key="Java" value="2 Months" />
                <entry key="Spring Framework" value="1 Month" />
                <entry key="Hibernate" value="3 Weeks" />
            </map>
        </property>

        <!-- 5. Injecting Environment Configuration Properties -->
        <property name="props">
            <props>
                <prop key="databaseUsername">root</prop>
                <prop key="databasePassword">admin123</prop>
            </props>
        </property>
    </bean>

</beans>
```

#### 3. The Application Execution Harness (`/com.springcore/src/main/java/com/springcore/App.java`)

Java

```java
package com.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting IoC Container Context...");

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml")) {
            
            // Fetch the fully populated collection bean
            Employee emp = (Employee) context.getBean("employee1");
            
            // Print the object structure output
            System.out.println(emp);
            
            // Verify structural implementation classes inside JVM memory
            System.out.println("\n--- Underlying Classes Selected By Spring ---");
            System.out.println("List Class implementation: " + emp.getPhones().getClass().getName());
            System.out.println("Set Class implementation: " + emp.getAddresses().getClass().getName());
            System.out.println("Map Class implementation: " + emp.getCourses().getClass().getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 3. 🏁 Expected Console Output Execution

When you run `App.java`, the container automatically maps data, handles conversions, parses XML elements, and generates clean runtime types:

Plaintext

```
Starting IoC Container Context...
Employee Summary:
 -> Name: Musaib
 -> Phone List: [9876543210, 8888888888, 9876543210]
 -> Address Set: [Sangli, Solapur]
 -> Course Map: {Java=2 Months, Spring Framework=1 Month, Hibernate=3 Weeks}
 -> Properties: {databasePassword=admin123, databaseUsername=root}

--- Underlying Classes Selected By Spring ---
List Class implementation: java.util.ArrayList
Set Class implementation: java.util.LinkedHashSet
Map Class implementation: java.util.LinkedHashMap
```

> [!NOTE] **What Concrete Collections Does Spring Use?**
> 
> By default, Spring uses **`java.util.ArrayList`** for lists, **`java.util.LinkedHashSet`** for sets, and **`java.util.LinkedHashMap`** for maps. This ensures your data maintains the exact entry order you typed inside your `config.xml` document file layout!

### 💡 Interview Focus: What if a list contains other custom Beans instead of simple Strings?

If a collection needs to reference other Java objects (beans) rather than plain text strings, you swap out the text `<value>` elements or string attributes for reference structural mappings using the **`ref bean="..."`** syntax:

XML

```xml
<property name="teamMembers">
    <list>
        <!-- Injects pre-existing independent objects that were defined elsewhere in the XML -->
        <ref bean="student1" />
        <ref bean="student2" />
    </list>
</property>
```
