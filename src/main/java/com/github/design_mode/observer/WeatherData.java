package com.github.design_mode.observer;

import java.util.ArrayList;
import java.util.List;

//主题主题
public class WeatherData implements Subject {

    private List<Observer> observers;
    private float temp;
    private float hum;
    private float pres;

    public WeatherData(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if(index >= 0){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(e -> e.update(temp, hum, pres));
    }

    //数据发生改变
    public void measurementsChanged(){
        notifyObservers();
    }

    //获取新数据
    public void setMeasurements(float temp, float hum, float pres){
        this.temp = temp;
        this.hum = hum;
        this.pres = pres;
        measurementsChanged();
    }

    //返回温度
    public float getTemperature(){
        return temp;
    }

    public float getHumidity(){
        return hum;
    }

    public float getPressure(){
        return pres;
    }

}
