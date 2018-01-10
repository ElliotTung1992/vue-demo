package com.github.dge1992.headfirst.test._2_1;

/**
 * @author  dong
 * @create  2018/1/10 14:15
 * @desc 观察者接口
 **/
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
