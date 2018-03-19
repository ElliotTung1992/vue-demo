package com.github.design_mode.strategy.simple_demo;


public class SimpleDemo {

    public static void main(String[] args) {
        Context context = new Context(null);
        String type = "C";
        if(type.equals("A")){
            context.setStrategy(new StrategyA());
        } else if(type.equals("B")){
            context.setStrategy(new StrategyB());
        } else if(type.equals("C")){
            context.setStrategy(new StrategyC());
        }
        context.operate();
    }
}

//环境
class Context implements Strategy{

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    @Override
    public void operate() {
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