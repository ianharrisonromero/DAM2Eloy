1. **Intent - Crear una instancia**:

   ```java
   Intent intent = new Intent(context, TargetActivity.class);
   ```

2. **Intent - Establecer datos**:

   ```java
   intent.putExtra("key", value);
   ```

3. **Intent - Iniciar una actividad**:

   ```java
   startActivity(intent);
   ```

4. **Intent - Obtener datos de retorno**:

   ```java
   startActivityForResult(intent, requestCode);
   ```

5. **Intent - Obtener datos en la actividad de destino**:

    ```java
    Intent intent = getIntent();
    // dependiendo del tipo de dato : 
    String stringValue = intent.getStringExtra("key");
    int intValue = intent.getIntExtra("key", defaultValue);
    boolean booleanValue = intent.getBooleanExtra("key", defaultValue);
    float floatValue = intent.getFloatExtra("key", defaultValue);
    double doubleValue = intent.getDoubleExtra("key", defaultValue);
    Parcelable parcelableValue = intent.getParcelableExtra("key");
    Serializable serializableValue = intent.getSerializableExtra("key");
    ```

6. **Intent - Verificar si hay componentes disponibles para manejarlo**:

   ```java
   PackageManager packageManager = getPackageManager();
   List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
   boolean isIntentSafe = activities.size() > 0;
   ```

7. **Pasar un objeto serializable**:

    ```java
    Intent intent = new Intent(this, TargetActivity.class);
    MySerializableObject obj = new MySerializableObject();
    intent.putExtra("key", obj);
    startActivity(intent);
    ```

Y para recibir el objeto en la actividad de destino:

   ```java
    Intent intent = getIntent();
    MySerializableObject obj = (MySerializableObject) intent.getSerializableExtra("key");
   ```

Estos son algunos de los métodos más comunes y esenciales de la clase `Intent` en Android, utilizados para iniciar actividades, pasar datos entre actividades y verificar la disponibilidad de componentes para manejar el intent.
