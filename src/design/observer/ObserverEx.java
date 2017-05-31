package design.observer;

public class ObserverEx {

    public static void main(String[] args) {
        WeatherData data = new WeatherData();
        data.addObserver(new Forecast());
        data.set(10, 10.0);

    }
}
