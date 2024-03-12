## SPINNER

1. **setAdapter()**: Establece el adaptador que proporciona los datos y las vistas para mostrar en el Spinner.

   ```java
   Spinner spinner = findViewById(R.id.spinner);
   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
   spinner.setAdapter(adapter);

   //EL DE RITZ:
   ArrayAdapter<Ciudades> adapter = new ArrayAdapter<>(this,com.google.android.material.R.layout.support_simple_spinner_dropdown_item, listaCiudades);
       spinnerOrigen.setAdapter(adapter);
       spinnerDestino.setAdapter(adapter);

   ```

2. **setOnItemSelectedListener()**: Establece un escuchador que se invoca cuando se selecciona un elemento en el `Spinner`.

   ```java
   spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
       @Override
       public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
           String item = parent.getItemAtPosition(position).toString();
           Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
       }

       @Override
       public void onNothingSelected(AdapterView<?> parent) {
           // No se seleccionó ningún elemento
       }
   });

   ```

3. **getSelectedItem()**: Devuelve el elemento seleccionado actualmente en el Spinner.

   ```java
   Object selectedItem = spinner.getSelectedItem();

   //RITZ:
   if (checkBoxSoloIda.isChecked()) {
        viaje = new Viaje(spinnerOrigen.getSelectedItem().toString(), spinnerDestino.getSelectedItem().toString(), fechaSalida, null);
   ```

4. **setSelection()**: Establece la selección actual del `Spinner` por posición.

   ```java
   spinner.setSelection(2);

   ```

5. **setEnabled()**: Establece si el `Spinner` está habilitado para interacción o no.

   ```java
   spinner.setEnabled(false);
   ```

6. **getAdapter()**: Devuelve el adaptador asociado con este `Spinner`.

   ```java
   SpinnerAdapter adapter = spinner.getAdapter();
   ```
