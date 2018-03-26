package com.github.design_mode.observer;

//主题
public interface Subject {

    //新增观察者
    void registerObserver(Observer observer);

    //移除观察者
    void removeObserver(Observer observer);

    //通知观察者
    void notifyObservers();
}
