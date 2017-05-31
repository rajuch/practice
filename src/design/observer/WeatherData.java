package design.observer;

import java.util.Observable;

public class WeatherData extends Observable {

    private int temp;
    private double humidity;

    public void set(int temp, double humidity) {
        this.temp = temp;
        this.humidity = humidity;

    }

    private void update() {
        notifyObservers(this);
    }

    public int getTemp() {
        return temp;
    }

    public double getHumidity() {
        return humidity;
    }
}
