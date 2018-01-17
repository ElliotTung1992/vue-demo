package com.github.dge1992.headfirst.test._4_2;

import java.util.ArrayList;
import java.util.stream.IntStream;

public abstract class Pizza {

    String name;
    String dough;
    String sauce;
    ArrayList toppings = new ArrayList();

    void prepare(){
        IntStream.range(0, toppings.size()).forEach(e -> System.out.println(e));
    }
    void bake(){
        System.out.println("bake");
    }
    void cut(){
        System.out.println("cut");
    }
    void box(){
        System.out.println("box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public ArrayList getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList toppings) {
        this.toppings = toppings;
    }
}
