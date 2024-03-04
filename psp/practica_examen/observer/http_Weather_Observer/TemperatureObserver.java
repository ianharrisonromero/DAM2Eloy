package http_Weather_Observer;
class TemperatureObserver implements WeatherObserverInterface {
    
    @Override
    public void update(double temperature, double humidity) {
        System.out.println("Temperature: " + temperature + " Celsius");
    }
}
