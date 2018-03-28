package com.github.design_mode.decker;

public class SimpleDemo {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Component concreteDecoratorA = new ConcreteDecoratorA(component);
        Component concreteDecoratorB = new ConcreteDecoratorB(concreteDecoratorA);
        concreteDecoratorB.execute();
    }
}

//组件
abstract class Component {
    abstract void execute();
}

//具体组件
class ConcreteComponent extends Component{

    @Override
    void execute() {
        System.out.println("执行操作");
    }
}

//装饰者接口
abstract class Decorator extends Component{

}

//具体装饰者A
class ConcreteDecoratorA extends Decorator {

    Component component;

    public ConcreteDecoratorA(Component component){
        this.component = component;
    }

    @Override
    void execute() {
        component.execute();
        System.out.println("装饰者A执行操作");
    }
}

//具体装饰者B
class ConcreteDecoratorB extends Decorator {

    Component component;

    public ConcreteDecoratorB(Component component){
        this.component = component;
    }

    @Override
    void execute() {
        component.execute();
        System.out.println("装饰者B执行操作");
    }
}

