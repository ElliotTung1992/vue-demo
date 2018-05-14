package com.github.design_mode.state.part2;

import java.util.Random;

public class Part2 {

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        System.out.println(gumballMachine);

        gumballMachine.turnCrank();
        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
    }
}

//状态接口
interface State{
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}

//糖果机
class GumballMachine{

    State noQuarterState;
    State soldOutState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;

        noQuarterState = new NoQuarterState(this);
        soldOutState = new SoldOutState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        if(count > 0){
            state = noQuarterState;
        }
    }

    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter(){
        state.ejectQuarter();
    }

    public void turnCrank(){
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall(){
        System.out.println("滚动起来出糖果喽！！！");
        if(count != 0){
            count = count - 1;
        }
    }


    public State getNoQuarterState() {
        return noQuarterState;
    }

    public void setNoQuarterState(State noQuarterState) {
        this.noQuarterState = noQuarterState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public void setSoldOutState(State soldOutState) {
        this.soldOutState = soldOutState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public void setHasQuarterState(State hasQuarterState) {
        this.hasQuarterState = hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public void setSoldState(State soldState) {
        this.soldState = soldState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public void setWinnerState(State winnerState) {
        this.winnerState = winnerState;
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}

//请投钱状态
class NoQuarterState implements State{

    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你投钱了");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("请先投钱");
    }

    @Override
    public void turnCrank() {
        System.out.println("请先投钱");
    }

    @Override
    public void dispense() {
        System.out.println("请先投钱");
    }
}

//卖完状态
class SoldOutState implements State{

    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("不好意思，卖完了");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("不好意思，卖完了");
    }

    @Override
    public void turnCrank() {
        System.out.println("不好意思，卖完了");
    }

    @Override
    public void dispense() {
        System.out.println("不好意思，卖完了");
    }
}

//已投钱状态
class HasQuarterState implements State{

    GumballMachine gumballMachine;
    Random randomWinner = new Random(System.currentTimeMillis());

    public HasQuarterState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你已经投钱了！！");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("正在退钱!!!");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("转动...");
        int winner = randomWinner.nextInt(10);
        if(winner == 0 && gumballMachine.getCount() > 1){
            gumballMachine.setState(gumballMachine.getWinnerState());
        }else{
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("....");
    }
}

//出售状态
class SoldState implements State{

    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你已经投钱了");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("正在出糖，无法退钱");
    }

    @Override
    public void turnCrank() {
        System.out.println("正在出糖，无法转动");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if(gumballMachine.getCount() > 0){
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }else{
            System.out.println("卖完喽！！！");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}

//中奖状态
class WinnerState implements State{

    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {
        System.out.println("你中奖了");
        gumballMachine.releaseBall();
        if(gumballMachine.getCount() == 0){
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }else{
            gumballMachine.releaseBall();
            if(gumballMachine.getCount() > 0){
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            }else{
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }
}
