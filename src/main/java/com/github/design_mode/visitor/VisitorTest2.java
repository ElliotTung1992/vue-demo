package com.github.design_mode.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 访问者模式
 */
public class VisitorTest2 {

    public static void main(String[] args) {
        List<Element> list = ObjectStruture.getList();
        for(Element e: list){
            e.accept(new Visitor());
        }
    }
}

/**
 * 抽象元素类
 */
abstract class Element {
    public abstract void accept(IVisitor visitor);
    public abstract void doSomething();
}

/**
 * 元素类
 */
class ConcreteElement1 extends Element {
    public void doSomething(){
        System.out.println("这是元素1");
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

/**
 * 元素类
 */
class ConcreteElement2 extends Element {
    public void doSomething(){
        System.out.println("这是元素2");
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

/**
 * 抽象访问者
 */
interface IVisitor {
    public void visit(ConcreteElement1 el1);
    public void visit(ConcreteElement2 el2);
}

/**
 * 访问者
 */
class Visitor implements IVisitor {

    public void visit(ConcreteElement1 el1) {
        el1.doSomething();
    }

    public void visit(ConcreteElement2 el2) {
        el2.doSomething();
    }
}

/**
 * 结构对象
 */
class ObjectStruture {
    public static List<Element> getList(){
        List<Element> list = new ArrayList();
        Random ran = new Random();
        for(int i=0; i<10; i++){
            int a = ran.nextInt(100);
            if(a>50){
                list.add(new ConcreteElement1());
            }else{
                list.add(new ConcreteElement2());
            }
        }
        return list;
    }
}