##**Calendar Class in Android Studio**

**1. Creation of Calendar Instance:**
You can create a Calendar instance using the getInstance() method:

```java
Calendar calendar = Calendar.getInstance();
```

**2. Getting and Setting Date/Time Components:**
The Calendar class allows you to retrieve and set various components of a date, such as year, month, day, hour, minute, and second:

```java
int year = calendar.get(Calendar.YEAR);
int month = calendar.get(Calendar.MONTH); // Note: Months are zero-based (0-11)
int day = calendar.get(Calendar.DAY_OF_MONTH);
int hour = calendar.get(Calendar.HOUR_OF_DAY);
int minute = calendar.get(Calendar.MINUTE);
int second = calendar.get(Calendar.SECOND);
```

You can also set these components using the set method:

```java
    calendar.set(Calendar.YEAR, 2023);
```

**3. Date/Time Manipulations:**
The add and roll methods are used for manipulating the date/time components:

```java
calendar.add(Calendar.DAY_OF_MONTH, 5); // Add 5 days to the current date
calendar.add(Calendar.YEAR, 1);
calendar.add(Calendar.MONTH, 3);
calendar.roll(Calendar.MONTH, true); // Roll the month forward by one, doesn't affect other fields
```

**4. getTime()**: Returns a Date object representing this Calendar's time value.

```java
Date date = calendar.getTime();
```

**. Formatting and Parsing:**
You can format the Calendar instance to a human-readable string using SimpleDateFormat:

```java
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String formattedDate = sdf.format(calendar.getTime());
```

Conversely, you can parse a string to a Calendar object:

```java
String dateString = "2023-12-01 14:30:00";
Date date = sdf.parse(dateString);
calendar.setTime(date);
```

**5. Comparison:**

**before()**

```java
Calendar calendar1 = Calendar.getInstance();
Calendar calendar2 = Calendar.getInstance();
calendar2.set(2023, Calendar.MARCH, 15);

boolean isBefore = calendar1.before(calendar2);
```

**after()**

```java
Calendar calendar1 = Calendar.getInstance();
Calendar calendar2 = Calendar.getInstance();
calendar2.set(2023, Calendar.MARCH, 15);

boolean isAfter = calendar1.after(calendar2);
```

Also you can compare two Calendar instances using the compareTo method:

```java
Calendar otherCalendar = Calendar.getInstance();
if (calendar.compareTo(otherCalendar) > 0) {
// calendar is after otherCalendar
} else if (calendar.compareTo(otherCalendar) < 0) {
// calendar is before otherCalendar
} else {
// calendar and otherCalendar are equal
}
```
