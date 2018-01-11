package com.github.dge1992.headfirst.test._3;

public class DarkRoast extends Beverage{

    public DarkRoast(){
        setDescription("DarkRoast");
    }

    @Override
    public void cost() {
        System.out.println("110");
    }
}
