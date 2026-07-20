In a Spring XML configuration, there are three primary ways to define and inject property values into your beans.

### 1. Using the `<property>` tag with the `value` attribute

This is the most common and standard approach for injecting literal values (like strings, numbers, and booleans).

XML

```xml
<bean id="student1" class="com.springcore.Student">
    <property name="studentId" value="25333" />
    <property name="studentName" value="Musaib" />
</bean>
```

### 2. Using the `<property>` tag with a nested `<value>` element

This approach separates the property name from the actual value container. It is highly useful if your string value contains special XML characters, as it allows you to wrap the text inside a `<![CDATA[...]]>` block.

XML

```xml
<bean id="student1" class="com.springcore.Student">
    <property name="studentName">
        <value>Musaib</value>
    </property>
</bean>
```

### 3. Using the `p-namespace` Shortcut

As demonstrated in your `student2` definition, the `p-namespace` is a declarative shortcut that eliminates the need for nested `<property>` tags entirely. It makes the XML significantly more concise by moving property declarations directly into the `<bean>` tag attributes.

- _Requirement:_ You must include `xmlns:p="[http://www.springframework.org/schema/p](http://www.springframework.org/schema/p)"` in the root `<beans>` element to use this.
    

XML

```xml
<bean id="student2" class="com.springcore.Student" 
      p:studentId="2534" 
      p:studentName="Asad" />
```

### 💡 Bonus: What if the property is another Object (Reference Injection)?

If you aren't injecting simple text values, but instead injecting another bean (a dependency), the syntax shifts slightly. You can use the `ref` attribute or the `p:property-ref` shortcut:

XML

```xml
<!-- Standard Ref Attribute -->
<property name="address" ref="addressBean" />

<!-- Nested Ref Element -->
<property name="address"><ref bean="addressBean"/></property>

<!-- p-namespace Ref Shortcut -->
<bean id="student1" class="com.springcore.Student" p:address-ref="addressBean" />
```