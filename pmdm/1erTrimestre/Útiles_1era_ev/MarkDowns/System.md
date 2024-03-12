# SYSTEM

### `System.arraycopy()`

The `arraycopy()` method is used to copy elements from one array to another. It allows you to specify the source array, the starting position in the source array, the destination array, the starting position in the destination array, and the number of elements to copy.

```java
int[] sourceArray = {1, 2, 3, 4, 5};
int[] destinationArray = new int[5];
System.arraycopy(sourceArray, 0, destinationArray, 0, sourceArray.length);

```

### `System.currentTimeMillis()`

The `currentTimeMillis()` method returns the current time in milliseconds since the Unix epoch (January 1, 1970). It is often used for measuring elapsed time or setting timestamps.

```java
long currentTime = System.currentTimeMillis();
System.out.println("Current time in milliseconds: " + currentTime);

```

### `System.exit()`

The `exit()` method is used to terminate the currently running Java Virtual Machine (JVM) with a specified exit status. It can be used to halt the execution of a program under certain conditions.

```java
if (condition) {
    System.exit(0); // Terminate the program with exit status 0
}

```

### `System.gc()`

The `gc()` method is a hint to the Java Virtual Machine (JVM) to perform garbage collection. It suggests that the JVM should make a best effort to reclaim unused memory, but it does not guarantee that garbage collection will occur.

```java
System.gc(); // Hint JVM to perform garbage collection
```
