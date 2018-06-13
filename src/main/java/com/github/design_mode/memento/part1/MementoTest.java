package com.github.design_mode.memento.part1;

/**
 * "白箱"备忘录模式
 */
public class MementoTest {

    public static void main(String[] args) {
        //发起人
        Originator originator = new Originator();
        //负责人
        Caretaker caretaker = new Caretaker();

        originator.setState("Hi");
        caretaker.saveMemento(originator.createMemento());

        originator.setState("Hello");
        originator.restoreMemento(caretaker.retrieveMemento());

        System.out.println(originator.getState());
    }
}

/**
 * 发起人角色类
 */
class Originator{

    private String state;

    /**
     * 工厂方法，返回一个新的备忘录对象
     */
    public Memento createMemento(){
        return new Memento(state);
    }
    /**
     * 将发起人恢复到备忘录对象所记载的状态
     */
    public void restoreMemento(Memento memento){
        this.state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        System.out.println("当前状态:" + this.state);
    }
}

/**
 * 备忘录角色类
 */
class Memento{

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

/**
 * 负责人角色类
 */
class Caretaker{

    private Memento memento;

    /**
     * 备忘录的取值方法
     */
    public Memento retrieveMemento(){
        return this.memento;
    }
    /**
     * 备忘录的赋值方法
     */
    public void saveMemento(Memento memento){
        this.memento = memento;
    }
}
