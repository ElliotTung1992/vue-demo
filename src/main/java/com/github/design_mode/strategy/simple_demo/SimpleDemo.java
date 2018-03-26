package com.github.design_mode.strategy.simple_demo;


public class SimpleDemo {

    public static void main(String[] args) {

        Context context = new Context(null);
        context.setStrategy(new StrategyC());
        context.execution();
    }
}

//环境
class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void execution() {
        strategy.operate();
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
}

//策略
interface Strategy{
    void operate();
}

//策略A
class StrategyA implements Strategy {

    @Override
    public void operate() {
        System.out.println("A方案");
    }
}

//策略B
class StrategyB implements Strategy {

    @Override
    public void operate() {
        System.out.println("B方案");
    }
}

//策略C
class StrategyC implements Strategy {

    @Override
    public void operate() {
        System.out.println("C方案");
    }
}