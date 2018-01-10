package com.github.dge1992.headfirst.test._2;

public class WeatherDate {

    private float temp;
    private float humidity;
    private float pressure;

    private CurrentConditionsDisplay currentConditionsDisplay;
    private StatisticsDisplay statisticsDisplay;
    private ForecastDisplay forecastDisplay;

    public void measurementsChanged(){

        float temp = getTemp();
        float humidity = getHumidity();
        float pressure = getPressure();

        currentConditionsDisplay.update(temp, humidity, pressure);
        statisticsDisplay.update(temp, humidity, pressure);
        forecastDisplay.update(temp, humidity, pressure);
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}
