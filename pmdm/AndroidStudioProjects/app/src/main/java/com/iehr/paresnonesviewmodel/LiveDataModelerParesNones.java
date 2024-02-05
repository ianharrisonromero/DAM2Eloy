package com.iehr.paresnonesviewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.HashMap;

public class LiveDataModelerParesNones extends ViewModel {
    private static final double DELAY = 2000;
    private static final int MAX_NUM = 10000;
    public static final Integer FAIL = -1;
    private MutableLiveData<Integer> misDatos;

    public LiveData<Integer> getNumero(){
        if(misDatos == null){
            misDatos = new MutableLiveData<Integer>();
            cargaNumero();
        }
        return misDatos;
    }

    public void cargaNumero() {
        // Magia de threads!!! Ulver está feliz :)
        new Thread(
                ()->{
                    try {
                        Thread.sleep((long) ((Math.random() * DELAY) + DELAY));
                        // He recibido los datos (simulando petición remota)
                        int i = (int) (Math.random() * MAX_NUM);
                        // ¿?
                        misDatos.postValue(i);
                    } catch (InterruptedException e) {
                        misDatos.postValue(FAIL);
                        //throw new RuntimeException(e);
                    }
                }
        ).start();
    }
}
