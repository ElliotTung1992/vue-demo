package com.github.design_mode.state.part1;

public class Part1 {

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.ejectQuarter();

        System.out.println(gumballMachine);
    }
}

/**
 * 糖果机
 */
class GumballMachine{

    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;

    int state = SOLD_OUT;
    int count = 0;

    public GumballMachine(int count){
        this.count = count;
        if(count > 0){
            state = NO_QUARTER;
        }
    }

    //投钱
    public void insertQuarter(){
        if(state == HAS_QUARTER){
            System.out.println("你已经投钱了");
        }else if(state == SOLD_OUT){
            System.out.println("不能投钱，没货啦");
        }else if(state == SOLD){
            System.out.println("正在出货");
        }else if(state == NO_QUARTER){
            state = HAS_QUARTER;
            System.out.println("你投钱了");
        }
    }

    //退钱
    public void ejectQuarter(){
        if(state == HAS_QUARTER){
            state = NO_QUARTER;
            System.out.println("正在退钱");
        }else if(state == SOLD_OUT){
            System.out.println("请先投钱");
        }else if(state == SOLD){
            System.out.println("请先投钱");
        }else if(state == NO_QUARTER){
            state = HAS_QUARTER;
            System.out.println("请先投钱");
        }
    }

    //转动曲柄
    public void turnCrank(){
        if(state == HAS_QUARTER){
            state = SOLD;
            System.out.println("正在发糖");
            dispense();
        }else if(state == SOLD_OUT){
            System.out.println("误操作");
        }else if(state == SOLD){
            System.out.println("误操作");
        }else if(state == NO_QUARTER){
            state = HAS_QUARTER;
            System.out.println("误操作");
        }
    }

    //发放糖果
    private void dispense() {
        if(state == SOLD){
            System.out.println("出糖!!!");
            count = count - 1;
            if(count == 0){
                System.out.println("糖卖完了");
                state = SOLD_OUT;
            }else {
                state = NO_QUARTER;
            }
        }else if(state == HAS_QUARTER){
            System.out.println("误操作");
        }else if(state == SOLD_OUT){
            System.out.println("误操作");
        }else if(state == NO_QUARTER){
            state = HAS_QUARTER;
            System.out.println("误操作");
        }
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}
