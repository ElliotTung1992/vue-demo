package com.github.design_mode.observer;

//统计布告板
public class StatisticsDisplay implements Observer, DisplayElement{

    private float temp;
    private float hum;
    private float pressure;
    private Subject subject;

    public StatisticsDisplay(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.hum = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Statistics Conditions: temp " + temp + " hum " + hum + " pressure:" + pressure);
    }
}
