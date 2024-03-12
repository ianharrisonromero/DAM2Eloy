# Enum in Java - Useful Use Cases and Useful METHODS

### 1. Enumeration Constants

An `Enum` in Java allows you to define a set of named constants, making your code more readable and maintainable by providing meaningful names for values.

```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}
```

### 2. Type Safety

Enums provide type safety, ensuring that only specified constants can be assigned to variables of that enum type, reducing the risk of errors in your code.

```java
public enum Season {
    WINTER, SPRING, SUMMER, FALL;
}

Season currentSeason = Season.SUMMER; // Valid assignment
// Season currentSeason = Season.FALL;   // Valid assignment
// Season currentSeason = Season.RAINY;  // Compilation error: RAINY is not part of Season enum
```

### 3. Singleton Pattern

Enums can be used to implement the Singleton pattern, ensuring that only one instance of a class exists within the JVM, making it thread-safe without the need for explicit synchronization.

```java
public enum Singleton {
    INSTANCE;

    // Add methods and fields here
}
```

### 4. Enum Constructors and Methods

Enums can have constructors and methods like any other Java class, allowing you to initialize enum constants with specific values or behaviors.

```java
public enum Operation {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
```

### 5. Switch Statements

Enums are often used with switch statements, providing a concise and readable way to handle different cases based on enum constants.

```java
public enum TrafficLight {
    RED, YELLOW, GREEN;
}

TrafficLight light = TrafficLight.RED;
switch (light) {
case RED:
// Stop
break;
case YELLOW:
// Prepare to stop or proceed with caution
break;
case GREEN:
// Go
break;
}
```

### 6. Enum Set

Java provides `EnumSet`, a specialized Set implementation for use with enum types, offering high performance and memory efficiency when dealing with a fixed set of elements.

```java
EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
```

### 7. Enum Maps

Similar to EnumSet, `EnumMap` is a specialized Map implementation optimized for enums as keys, providing efficient storage and retrieval of key-value pairs.

```java
EnumMap<Day, String> dayTasks = new EnumMap<>(Day.class);
dayTasks.put(Day.MONDAY, "Meeting");
dayTasks.put(Day.FRIDAY, "Code Review");
```

### 8. Enum Iteration

Enums can be easily iterated over using the `values()` method, which returns an array containing all enum constants, simplifying tasks like printing all enum values.

```java
for (Operation op : Operation.values()) {
    System.out.println(op.getSymbol());
}
```

### 9. State Representation

Enums are often used to represent states or options in various scenarios, providing a clear and self-explanatory way to define and work with different states of an application.

```java
public enum ConnectionState {
    CONNECTED, DISCONNECTED, RECONNECTING;
}
```

### 10. Conditional Logic

Enums can be used in conditional logic to improve code readability by replacing magic numbers or strings with meaningful enum constants, enhancing code clarity and maintainability.

```java
public enum LogLevel {
    DEBUG, INFO, WARNING, ERROR;
}

LogLevel currentLevel = LogLevel.INFO;

if (currentLevel == LogLevel.ERROR) {
    // Log error message
} else if (currentLevel == LogLevel.WARNING) {
    // Log warning message
} else {
    // Log other messages
}
```

## Additional Useful Methods for Enums

### 1. `valueOf(String name)`

The `valueOf(String name)` method returns the enum constant with the specified name. This method throws an `IllegalArgumentException` if no enum constant with the specified name exists.

```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

Day day = Day.valueOf("MONDAY");
System.out.println(day); // Output: MONDAY

```

### 2. `ordinal()`

The `ordinal()` method returns the ordinal of this enumeration constant (its position in its enum declaration, where the initial constant is assigned an ordinal of zero).

```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

Day day = Day.WEDNESDAY;
System.out.println(day.ordinal()); // Output: 2
```

### 3. `name()`

The `name()` method returns the name of this enum constant, exactly as declared in its enum declaration.

```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

Day day = Day.FRIDAY;
System.out.println(day.name()); // Output: FRIDAY
```

### 4. `compareTo(EnumType o)`

The `compareTo(EnumType o)` method compares this enum with the specified object for order. It returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.

```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

Day day1 = Day.MONDAY;
Day day2 = Day.FRIDAY;
System.out.println(day1.compareTo(day2)); // Output: -4
```

### 5. `toString()`

The `toString()` method returns the name of this enum constant, as contained in the declaration.

```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

Day day = Day.SATURDAY;
System.out.println(day.toString()); // Output: SATURDAY
```

### 6. `values()`

The `values()` method returns an array containing all the enum constants in the order they are declared.

```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

ArrayList<Day> dayList = new ArrayList<>(Arrays.asList(Day.values()));
for (Day d : dayList) {
    System.out.println(d);
}

//OR

Day[] days = Day.values();
for (Day d : days) {
    System.out.println(d);
}
```
