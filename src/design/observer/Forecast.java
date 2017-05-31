package design.observer;

import java.util.Observable;
import java.util.Observer;

public class Forecast implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData data = (WeatherData) arg;
            System.out.println(data.getHumidity());
        }
    }
}
