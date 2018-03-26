package com.github.design_mode.observer;

//目前状况布告板
public class CurrentConditionsDisplay implements Observer, DisplayElement{

    private float temp;
    private float hum;
    private Subject subject;

    public CurrentConditionsDisplay(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.hum = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current Conditions: temp " + temp + " hum " + hum);
    }
}
