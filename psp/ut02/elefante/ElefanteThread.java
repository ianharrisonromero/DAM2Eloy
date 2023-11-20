// Basándote en esa canción, crea un Thread que reciba el tipo de animal, la acción y el número máximo.
//  Cada vez que escriba una estrofa, el thread generará un número aleatorio entre 100000 y 300000 
//  y verificará si es primo.
// Crea un programa principal que gestion 3 canciones infantiles de forma concurrente con distintas 
// prioridades (setPriority). Las canciones serán veriones de los elefantes pero con distinto animal y acción.

import java.util.Random;

class ElefanteThread extends Thread {
  private String animal;
  private String accion;
  private int maxEstrofas;
  public static final int MIN_ALEATORIO = 100000;
  public static final int MAX_ALEATORIO = 300000;

  public ElefanteThread(String animal, String accion, int maxEstrofas) {
    this.animal = animal;
    this.accion = accion;
    this.maxEstrofas = maxEstrofas;
  }

  private boolean esPrimo(int numero) {
    for (int i = 2; i <= Math.sqrt(numero); i++) {
      if (numero % i == 0) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void run() {
    for (int i = 1; i <= maxEstrofas; i++) {
      System.out.println(animal + " " + accion + " sobre la tela de una araña");
      Random rand = new Random();
      int numAleatorio = rand.nextInt(MAX_ALEATORIO) + MIN_ALEATORIO;
      
      if (esPrimo(numAleatorio)) {
        System.out.println("Tiempo de espera (" + numAleatorio + ") es primo!");
      } else {
        System.out.println("Tiempo de espera (" + numAleatorio + ") no es primo.");
      }
      
    }
  }
}

// public class CancionesInfantiles {
//   public static void main(String[] args) {
//     ElefanteThread elefante1 = new ElefanteThread("Elefante", "se balanceaba", 5);
//     ElefanteThread elefante2 = new ElefanteThread("Mono", "serpenteaba", 5);
//     ElefanteThread elefante3 = new ElefanteThread("Oso", "saltaba", 5);

//     // prioridades
//     elefante1.setPriority(Thread.MAX_PRIORITY);
//     elefante2.setPriority(Thread.NORM_PRIORITY);
//     elefante3.setPriority(Thread.MIN_PRIORITY);

//     elefante1.start();
//     elefante2.start();
//     elefante3.start();
//   }
// }
