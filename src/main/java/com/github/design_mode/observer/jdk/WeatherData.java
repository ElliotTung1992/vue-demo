package com.github.design_mode.observer.jdk;


import java.util.Observable;

//主题
public class WeatherData extends Observable{

    private float temp;
    private float hum;
    private float pre;

    WeatherData(){

    }

    //数据发生改变
    public void measurementsChanged(){
        //可以发送通知
        setChanged();
        notifyObservers();
    }

    //获取新数据
    public void setMeasurements(float temp, float hum, float pre){
        this.temp = temp;
        this.hum = hum;
        this.pre = pre;
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
        return pre;
    }
}
