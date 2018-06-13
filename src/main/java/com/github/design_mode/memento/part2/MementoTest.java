package com.github.design_mode.memento.part2;

/**
 * "黑箱"备忘录模式
 */
public class MementoTest {

    public static void main(String[] args) {
        //发起人
        Originator originator = new Originator();
        //负责人
        Caretaker caretaker = new Caretaker();
        //设置发起人的状态
        originator.setState("Hi");
        //创建备忘录对象
        caretaker.saveMemento(originator.createMemento());
        //修改发起人的状态
        originator.setState("Hello");
        originator.restoreMemento(caretaker.retrieveMemento());

        //查看发起人状态
        System.out.println(originator.getState());
    }
}

/**
 * 发起人角色类
 */
class Originator{

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        System.out.println("赋值状态：" + state);
    }

    /**
     * 工厂方法，返还一个新的备忘录对象
     */
    public MementoIF createMemento(){
        return new Memento(state);
    }

    /**
     * 发起人恢复到备忘录对象记录的状态
     */
    public void restoreMemento(MementoIF memento){
        this.setState(((Memento)memento).getState());
    }

    private class Memento implements MementoIF{

        private String state;
        /**
         * 构造方法
         */
        private Memento(String state){
            this.state = state;
        }

        private String getState() {
            return state;
        }
        private void setState(String state) {
            this.state = state;
        }
    }
}

/**
 * 窄接口
 */
interface MementoIF{

}

/**
 * 负责人角色类
 */
class Caretaker{

    private MementoIF memento;

    /**
     * 备忘录取值方法
     */
    public MementoIF retrieveMemento(){
        return memento;
    }

    /**
     * 备忘录赋值方法
     */
    public void saveMemento(MementoIF memento){
        this.memento = memento;
    }
}
