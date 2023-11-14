package psp.EntrenamientoJava.Date;
public class MainDate {
  public static void main(String[] args) {

    DateThread threadObject = new DateThread();
    threadObject.start();

    DateRunnable runnableObject = new DateRunnable();
    Thread threadRunnable = new Thread(runnableObject); 
    threadRunnable.start();

    DateLambda lambdaObject = new DateLambda();
    Thread threadLambda = new Thread(lambdaObject);
    threadLambda.start();


  }
}
