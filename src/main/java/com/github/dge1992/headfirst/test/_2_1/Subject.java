package com.github.dge1992.headfirst.test._2_1;

/**
 * @author  dong
 * @create  2018/1/10 14:15
 * @desc 主题接口
 **/
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
