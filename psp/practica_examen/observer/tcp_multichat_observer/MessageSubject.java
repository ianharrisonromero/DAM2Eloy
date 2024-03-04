// package tcp_multichat_observer;

import java.util.ArrayList;
import java.util.List;

public class MessageSubject {
    private List<MessageObserver> observers = new ArrayList<>();

    public void attach(MessageObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (MessageObserver observer : observers) {
            observer.update(message);
        }
    }
}
