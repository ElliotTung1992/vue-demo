package com.github.design_mode.strategy.case1;

public class StrategyDemo {

    public static void main(String[] args) {

        Person person = new Person("小明", 30);
        Integer distance = person.getDistance();
        if(distance < 1000){
            System.out.println("走路");
        }else if(distance >= 1000 && distance < 2000){
            System.out.println("骑自行车");
        }else if(distance >= 2000){
            System.out.println("乘汽车");
        }

    }
}

class Person{

    public Person(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    //姓名
    private String name;
    //距离
    private Integer distance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}


