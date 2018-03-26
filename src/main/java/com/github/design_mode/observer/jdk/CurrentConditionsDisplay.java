package com.github.design_mode.observer.jdk;

import com.github.design_mode.observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

//观察者
public class CurrentConditionsDisplay implements Observer, DisplayElement{

    private float temp;
    private float hum;
    private Observable observable;

    public CurrentConditionsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData) o;
            this.temp = weatherData.getTemperature();
            this.hum = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current Conditions :" + "temp是" + temp + " hum是" + hum);
    }
}
