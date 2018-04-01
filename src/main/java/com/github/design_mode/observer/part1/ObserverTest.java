package com.github.design_mode.observer.part1;

import java.util.ArrayList;
import java.util.List;

//观察者模式
public class ObserverTest {

    public static void main(String[] args) {
        //创建主题
        NewsOffice newsOffice = new NewsOffice();
        //董先生订阅报纸
        Dong dong = new Dong(newsOffice);
        //冯先生订阅报纸
        Feng feng = new Feng(newsOffice);
        //发生大事了
        newsOffice.breakingNews("宁波厕所炸了！！！", "晴", "小明走失了");
        //冯先生退订
        newsOffice.removeObserver(feng);
        //发生大事了
        newsOffice.breakingNews("破案了，有人藏火药，宁波人的shi不背锅", "雨", "小明找到了");
    }
}

//主题
interface Subject{
    //新增观察者
    void registerObserver(Observer observer);
    //移除观察者模式
    void removeObserver(Observer observer);
    //通知观察者们
    void notifyObservers();
}

//观察者
interface Observer{
    //更新
    void update(String news, String weather, String manLost);
}

//阅读报纸
interface Read{
    void Read();
}

//报社
class NewsOffice implements Subject{

    //观察者集合
    private List<Observer> observers;
    //大事
    private String news;
    //天气
    private String weather;
    //寻人启事
    private String manLost;

    public NewsOffice(){
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if(index >= 0){
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(e -> e.update(news, weather, manLost));
    }

    //发报纸
    public void newsChanged(){
        notifyObservers();
    }

    //爆炸性新闻
    public void breakingNews(String news, String weather, String manLost){
        this.news = news;
        this.weather = weather;
        this.manLost = manLost;
        newsChanged();
    }
}

//董先生
class Dong implements Observer, Read{

    private String news;
    private String weather;
    private String manLost;
    private Subject subject;

    //订阅报纸
    public Dong(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }


    //收到报纸
    @Override
    public void update(String news, String weather, String manLost) {
        this.news = news;
        this.weather = weather;
        this.manLost = manLost;
        Read();
    }

    //看报纸
    @Override
    public void Read() {
        System.out.println("发生大事啦:" + news + " 天气:" + weather + " 寻人启事: " + manLost);
    }
}

//冯先生
class Feng implements Observer, Read{

    private String news;
    private Subject subject;
    private String weather;
    private String manLost;


    //订阅报纸
    public Feng(Subject subject){
        this.subject = subject;
        this.weather = weather;
        this.manLost = manLost;
        subject.registerObserver(this);
    }


    //收到报纸
    @Override
    public void update(String news, String weatherm, String manLost) {
        this.news = news;
        this.weather = weatherm;
        this.manLost = manLost;
        Read();
    }

    //看报纸
    @Override
    public void Read() {
        System.out.println("发生大事啦:" + news + " 天气:" + weather + " 寻人启事: " + manLost);
    }
}

//严先生
class Yan implements Observer, Read{

    private String news;
    private Subject subject;
    private String weather;
    private String manLost;

    //订阅报纸
    public Yan(Subject subject){
        this.subject = subject;
        subject.registerObserver(this);
    }


    //收到报纸
    @Override
    public void update(String news, String weather, String manLost) {
        this.news = news;
        this.weather = weather;
        this.manLost = manLost;
        Read();
    }

    //看报纸
    @Override
    public void Read() {
        System.out.println("发生大事啦:" + news + " 天气:" + weather + " 寻人启事: " + manLost);
    }
}
