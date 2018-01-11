package com.github.dge1992.headfirst.test._3;

public abstract class Beverage {

    private String description;

    abstract void cost();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
