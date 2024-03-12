1. **TimePicker - Crear una instancia**:

   ```java
   TimePicker timePicker = new TimePicker(context);
   ```

2. **TimePicker - Establecer hora inicial**:

   ```java
   timePicker.setHour(hour);
   timePicker.setMinute(minute);
   ```

3. **TimePicker - Obtener hora seleccionada**:

   ```java
   int hour = timePicker.getHour();
   int minute = timePicker.getMinute();
   ```

4. **TimePicker - Establecer escucha de cambios de hora**:

   ```java
   timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
       @Override
       public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
           // Manejar el cambio de hora
       }
   });
   ```

5. **TimePicker - Comparar con otra hora**:

   ```java
   int hour1 = timePicker1.getHour();
   int minute1 = timePicker1.getMinute();
   int hour2 = timePicker2.getHour();
   int minute2 = timePicker2.getMinute();

   if (hour1 < hour2 || (hour1 == hour2 && minute1 < minute2)) {
       // La hora seleccionada en timePicker1 es anterior a la hora seleccionada en timePicker2
   } else if (hour1 > hour2 || (hour1 == hour2 && minute1 > minute2)) {
       // La hora seleccionada en timePicker1 es posterior a la hora seleccionada en timePicker2
   } else {
       // Las horas seleccionadas son iguales
   }
   ```

6. **TimePicker - Convertir hora a formato de texto**:

   ```java
   int hour = timePicker.getHour();
   int minute = timePicker.getMinute();

   String timeString = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
   // Ejemplo de formato: "08:30"
   ```
