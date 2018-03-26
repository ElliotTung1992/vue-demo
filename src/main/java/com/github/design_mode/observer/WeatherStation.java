package com.github.design_mode.observer;

//气象站
public class WeatherStation {

    public static void main(String[] args) {
        //主题
        WeatherData weatherData = new WeatherData();

        //观察者
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        //当主题发生变化，观察者接收到消息
        weatherData.setMeasurements(10, 20, 30);
        weatherData.setMeasurements(11, 21, 31);
        weatherData.setMeasurements(11, 22, 32);

    }
}
