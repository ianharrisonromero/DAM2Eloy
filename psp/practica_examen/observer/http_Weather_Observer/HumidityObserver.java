package http_Weather_Observer;
class HumidityObserver implements WeatherObserverInterface {
    @Override
    public void update(double temperature, double humidity) {
        System.out.println("Humidity: " + humidity + "%");
    }
}