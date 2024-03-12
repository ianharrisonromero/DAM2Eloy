1. **DatePicker - Crear una instancia**:

   ```java
   DatePicker datePicker = new DatePicker(context);
   ```

2. **DatePicker - Establecer fecha inicial**:

   ```java
   datePicker.init(year, month, dayOfMonth, null);
   ```

3. **DatePicker - Obtener fecha seleccionada**:

   ```java
   int year = datePicker.getYear();
   int month = datePicker.getMonth();
   int dayOfMonth = datePicker.getDayOfMonth();
   ```

4. **DatePicker - Establecer escucha de cambios de fecha**:

   ```java
   datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
       @Override
       public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
           // Manejar el cambio de fecha
       }
   });
   ```

5. **DatePicker - Establecer rango de fechas permitido**:

   ```java
   datePicker.setMinDate(minDate); //EJEMPLO COMPLETO ABAJO DEL TODO <--
   datePicker.setMaxDate(maxDate);
   ```

6. **DatePicker - Cambiar el estilo del DatePicker**:

   ```java
   datePicker.setCalendarViewShown(false);
   datePicker.setSpinnersShown(true);
   ```

### EJEMPLO COMPLETO DE RANGO:

```java
// Obtener la fecha actual
Calendar calendar = Calendar.getInstance();
int currentYear = calendar.get(Calendar.YEAR);
int currentMonth = calendar.get(Calendar.MONTH);
int currentDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

// Calcular la fecha mínima permitida (hoy)
long minDateMillis = calendar.getTimeInMillis();

// Calcular la fecha máxima permitida (dentro de un año)
calendar.add(Calendar.YEAR, 1);
long maxDateMillis = calendar.getTimeInMillis();

// Crear una instancia de DatePicker
DatePicker datePicker = new DatePicker(this);

// Establecer la fecha inicial y el rango de fechas permitido
datePicker.init(currentYear, currentMonth, currentDayOfMonth, null);
datePicker.setMinDate(minDateMillis);
datePicker.setMaxDate(maxDateMillis);

// Crear un diálogo para mostrar el DatePicker
AlertDialog.Builder builder = new AlertDialog.Builder(this);
builder.setView(datePicker);
builder.setPositiveButton("Seleccionar", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
        // Obtener la fecha seleccionada
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int dayOfMonth = datePicker.getDayOfMonth();

        // Hacer algo con la fecha seleccionada
        Toast.makeText(MainActivity.this, "Fecha seleccionada: " + dayOfMonth + "/" + (month + 1) + "/" + year, Toast.LENGTH_SHORT).show();
    }
});
builder.setNegativeButton("Cancelar", null);
builder.show();
```
