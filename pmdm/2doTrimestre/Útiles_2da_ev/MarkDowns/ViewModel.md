# Temario: ViewModel en Android

## Implementación de ViewModel

  ```java
  import androidx.lifecycle.ViewModel;
  public class MyViewModel extends ViewModel {
       // Variables y métodos de ViewModel
  }
  ```

Comunicación con la Actividad/Fragment
--------------------

```java
public class MyActivity extends AppCompatActivity {
private MyViewModel viewModel;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);

    viewModel = new ViewModelProvider(this).get(MyViewModel.class);
    // Acceso a datos del ViewModel
    }
}

```



Observación de datos
--------------------


```java
public class MyActivity extends AppCompatActivity {
    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.getData().observe(this, newData -> {
            // Actualizar la interfaz de usuario con los nuevos datos
        });
    }
}
```

*   Cómo observar cambios en los datos del ViewModel utilizando LiveData.

Manejo de la configuracion
--------------------

```java
public class MyViewModel extends ViewModel {
    private MutableLiveData<String> data;

    public LiveData<String> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
            loadData();
        }
        return data;
    }

    private void loadData() {
        // Código para cargar datos (por ejemplo, desde una base de datos o una API)
        data.setValue("Datos cargados desde ViewModel");
    }
}
```

