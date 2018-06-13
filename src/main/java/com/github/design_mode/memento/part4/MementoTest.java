package com.github.design_mode.memento.part4;

/**
 * 备忘录模式
 *
 * “自述历史”模式
 */
public class MementoTest {

    public static void main(String[] args) {

        Originator o = new Originator();
        //修改状态
        o.changeState("state 0");
        //创建备忘录
        MementoIF memento = o.createMemento();
        //修改状态
        o.changeState("state 1");
        //按照备忘录恢复对象的状态
        o.restoreMemento(memento);

        System.out.println(o.state);
    }
}

/**
 * 窄接口
 */
interface MementoIF{

}

/**
 * 发起人角色同时还兼任负责人角色
 */
class Originator{

    public String state;
    /**
     * 改变状态
     */
    public void changeState(String state){
        this.state = state;
        System.out.println("状态改变为：" + state);
    }
    /**
     * 工厂方法，返还一个新的备忘录对象
     */
    public Memento createMemento(){
        return new Memento(this);
    }
    /**
     * 将发起人恢复到备忘录对象所记录的状态上
     */
    public void restoreMemento(MementoIF memento){
        Memento m = (Memento)memento;
        changeState(m.state);
    }

    private class Memento implements MementoIF{

        private String state;
        /**
         * 构造方法
         */
        private Memento(Originator o){
            this.state = o.state;
        }
        private String getState() {
            return state;
        }

    }
}
