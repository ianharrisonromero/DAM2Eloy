// Basándote en esa canción, crea un Thread que reciba el tipo de animal, la acción y el número máximo.
//  Cada vez que escriba una estrofa, el thread generará un número aleatorio entre 100000 y 300000 
//  y verificará si es primo.
// Crea un programa principal que gestion 3 canciones infantiles de forma concurrente con distintas 
// prioridades (setPriority). Las canciones serán veriones de los elefantes pero con distinto animal y acción.

import java.util.Random;

class Elefante2 extends Thread {
  private String animal;
  private String accion;
  private int numRepeticiones;
  public static final int MIN_ALEATORIO = 100000;
  public static final int MAX_ALEATORIO = 300000000;

  public Elefante2(String animal, String accion, int numRepeticiones) {
    this.animal = animal;
    this.accion = accion;
    this.numRepeticiones = numRepeticiones;
  }

  private boolean esPrimo() {
    Random rd = new Random();
    int numero = rd.nextInt(MAX_ALEATORIO)+MIN_ALEATORIO ;
    for (int i = 2; i <= Math.sqrt(numero); i++) {
      if (numero % i == 0) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void run() {
    for (int i = 1; i < numRepeticiones; i++) {
      System.out.println("\n" + i + " " + animal + " " + accion + " sobre la tela de una araña\n"
                          + "Como veía que no se caía, fueron a llamar a otro " + animal);
      
      System.out.println("\n" + animal + " Es numero primo? = " + esPrimo() + "\n");
    }
  }

  public static void main(String[] args) {
    Elefante2 elefante = new Elefante2("elefante", "se balanceaba", 20);
    Elefante2 mono = new Elefante2("mono", "serpenteaba", 20);
    Elefante2 oso = new Elefante2("oso", "saltaba", 15);
    // prioridades
    elefante.setPriority(Thread.MAX_PRIORITY);
    mono.setPriority(Thread.NORM_PRIORITY);
    oso.setPriority(Thread.MIN_PRIORITY);

    elefante.start();
    oso.start();
    mono.start();
  }
}
