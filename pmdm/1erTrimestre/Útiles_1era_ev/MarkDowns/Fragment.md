1. **Fragment - Crear una instancia**:

   ```java
   MyFragment fragment = new MyFragment();
   ```

2. **Fragment - Crear argumentos**:

   ```java
   Bundle args = new Bundle();
   args.putString("key", "value");
   fragment.setArguments(args);
   ```

3. **Fragment - Inflar un diseño de interfaz de usuario**:

   ```java
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_layout, container, false);
   }
   ```

4. **Fragment - Obtener argumentos**:

   ```java
   Bundle args = getArguments();
   String value = args.getString("key");
   ```

5. **Fragment - Realizar transacciones de fragmentos**:

   ```java
   FragmentManager fragmentManager = getSupportFragmentManager();
   FragmentTransaction transaction = fragmentManager.beginTransaction();
   transaction.replace(R.id.fragment_container, fragment);
   transaction.addToBackStack(null);
   transaction.commit();
   ```

6. **Fragment - Comunicación con la actividad**:

   ```java
   MyActivity activity = (MyActivity) getActivity();
   activity.someMethod();
   ```

# SEGUNDA VERSION:

1. **Fragment - Crear una instancia**:

   ```java
   MyFragment fragment = new MyFragment();
   ```

2. **Fragment - Crear argumentos**:

   ```java
   Bundle args = new Bundle();
   args.putString("key", "value");
   fragment.setArguments(args);
   ```

3. **Fragment - Inflar un diseño de interfaz de usuario**:

   ```java
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_layout, container, false);
   }
   ```

4. **Fragment - Obtener argumentos**:

   ```java
   Bundle args = getArguments();
   String value = args.getString("key");
   ```

5. **Fragment - Realizar transacciones de fragmentos**:

   ```java
   FragmentManager fragmentManager = getSupportFragmentManager();
   FragmentTransaction transaction = fragmentManager.beginTransaction();
   transaction.replace(R.id.fragment_container, fragment);
   transaction.addToBackStack(null);
   transaction.commit();
   ```

6. **Fragment - Comunicación con la actividad**:

   ```java
   MyActivity activity = (MyActivity) getActivity();
   activity.someMethod();
   ```

Estos son algunos de los métodos más comunes y esenciales de la clase `Fragment` en Android, utilizados para su creación, manipulación y comunicación con la actividad anfitriona.
