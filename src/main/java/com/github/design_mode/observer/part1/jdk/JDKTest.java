package com.github.design_mode.observer.part1.jdk;


import java.util.Observable;
import java.util.Observer;

public class JDKTest {

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
        newsOffice.deleteObserver(feng);
        //发生大事了
        newsOffice.breakingNews("破案了，有人藏火药，宁波人的shi不背锅", "雨", "小明找到了");

    }
}

//阅读报纸
interface Read{
    void Read();
}

//报社
class NewsOffice extends Observable{

    //新闻
    private String news;
    //天气预报
    private String weather;
    //寻人启事
    private String manLost;

    public NewsOffice(){

    }

    //发报纸
    public void newsChanged(){
        //可以更新
        setChanged();
        notifyObservers();
    }

    //爆炸性新闻
    public void breakingNews(String news, String weather, String manLost){
        this.news = news;
        this.weather = weather;
        this.manLost = manLost;
        newsChanged();
    }

    public String getNews() {
        return news;
    }

    public String getWeather() {
        return weather;
    }

    public String getManLost() {
        return manLost;
    }
}

//董先生
class Dong implements Observer, Read{

    private String news;
    private String weather;
    private String manLost;
    private Observable observable;

    public Dong(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void Read() {
        System.out.println("发生大事啦:" + news + " 天气:" + weather);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof NewsOffice){
            NewsOffice newsOffice = (NewsOffice) o;
            this.news = newsOffice.getNews();
            this.weather = newsOffice.getWeather();
            Read();
        }
    }
}

//冯先生
class Feng implements Observer, Read{

    private String news;
    private String weather;
    private String manLost;
    private Observable observable;

    public Feng(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void Read() {
        System.out.println("发生大事啦:" + news );
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof NewsOffice){
            NewsOffice newsOffice = (NewsOffice) o;
            this.news = newsOffice.getNews();
            Read();
        }
    }
}
