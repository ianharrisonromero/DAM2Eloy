2. **EditText - Establecer texto**:

   ```java
   editText.setText("Texto a mostrar");
   ```

3. **EditText - Obtener texto ingresado**:

   ```java
   String text = editText.getText().toString();
   ```

4. **EditText - Establecer hint (texto de ayuda)**:

   ```java
   editText.setHint("Texto de ayuda");
   ```

5. **EditText - Establecer escucha de cambios de texto**:

   ```java
   editText.addTextChangedListener(new TextWatcher() {
       @Override
       public void beforeTextChanged(CharSequence s, int start, int count, int after) {
           // Antes de cambiar el texto
       }

       @Override
       public void onTextChanged(CharSequence s, int start, int before, int count) {
           // Durante el cambio de texto
       }

       @Override
       public void afterTextChanged(Editable s) {
           // Después de cambiar el texto
       }
   });
   ```
