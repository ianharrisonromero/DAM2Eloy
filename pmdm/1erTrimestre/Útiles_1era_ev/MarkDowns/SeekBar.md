2. **SeekBar - Establecer valor máximo**:

   ```java
   seekBar.setMax(100); // Valor máximo permitido en la SeekBar
   ```

3. **SeekBar - Establecer progreso actual**:

   ```java
   seekBar.setProgress(50); // Establecer el progreso actual de la SeekBar
   ```

4. **SeekBar - Establecer escucha de cambios de progreso**:

   ```java
   seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
       @Override
       public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
           // Manejar el cambio de progreso
       }

       @Override
       public void onStartTrackingTouch(SeekBar seekBar) {
           // Inicio de seguimiento del usuario
       }

       @Override
       public void onStopTrackingTouch(SeekBar seekBar) {
           // Fin de seguimiento del usuario
       }
   });
   ```

5. **SeekBar - Establecer color del progreso**:

   ```java
   seekBar.setProgressTintList(ColorStateList.valueOf(Color.BLUE)); // Establecer el color del progreso de la SeekBar
   ```

6. **SeekBar - Establecer altura del progreso**:

   ```java
   seekBar.setProgressHeight(20); // Establecer la altura del progreso de la SeekBar en píxeles
   ```
