package com.github.design_mode.visitor;

/**
 * 访问者模式
 *
 * 对于类A来说，类B就是一个访问者。
 */
public class VisitorTest {

    public static void main(String[] args) {
        A a = new A();
        a.show();
        a.accept(new B());
    }
}

class A{

    public void show(){
        System.out.println("i am A");
    }

    public void accept(B b){
        b.visit(this);
    }
}

class B{

    public void visit(A a){
        a.show();
    }
}


