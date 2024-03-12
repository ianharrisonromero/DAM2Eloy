1. **CheckBox - Crear una instancia**:

   ```java
   CheckBox checkBox = new CheckBox(context);
   ```

2. **CheckBox - Establecer texto**:

   ```java
   checkBox.setText("Texto del CheckBox");
   ```

3. **CheckBox - Establecer estado (marcado/desmarcado)**:

   ```java
   checkBox.setChecked(true);
   ```

4. **CheckBox - Verificar si está marcado**:

   ```java
   boolean isChecked = checkBox.isChecked();
   ```

5. **CheckBox - Establecer escucha de cambios de estado**:

   ```java
   checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
       @Override
       public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
           // Manejar el cambio de estado del CheckBox
       }
   });
   ```
