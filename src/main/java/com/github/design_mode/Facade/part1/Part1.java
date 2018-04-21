package com.github.design_mode.Facade.part1;

public class Part1 {

    public static void main(String[] args) {
        MethodA methodA = new MethodA();
        MethodB methodB = new MethodB();
        MethodC methodC = new MethodC();
        ClientOne clientOne = new ClientOne(methodA, methodB, methodC);

        clientOne.demandOne();
        clientOne.demandTwo();
        clientOne.demandThree();
    }
}

//客户端1
class ClientOne{

    MethodA methodA;
    MethodB methodB;
    MethodC methodC;

    public ClientOne(MethodA methodA, MethodB methodB, MethodC methodC){
        this.methodA = methodA;
        this.methodB = methodB;
        this.methodC = methodC;
    }

    //需求一
    public void demandOne(){
        methodA.execute();
        methodB.execute();
        methodC.execute();
    }

    //需求二
    public void demandTwo(){
        methodB.execute();
        methodC.execute();
        methodA.execute();
    }

    //需求三
    public void demandThree(){
        methodC.execute();
        methodA.execute();
        methodB.execute();
    }
}

//客户端2
class ClientTwo{

    Facade facade;

    public ClientTwo(Facade facade){
        this.facade = facade;
    }

    public void demandOne(){
        facade.demandOne();
    }
    public void demandTwo(){
        facade.demandTwo();
    }
    public void demandThree(){
        facade.demandThree();
    }
}

class Facade{

    MethodA methodA;
    MethodB methodB;
    MethodC methodC;

    public Facade(MethodA methodA, MethodB methodB, MethodC methodC){
        this.methodA = methodA;
        this.methodB = methodB;
        this.methodC = methodC;
    }

    //需求一
    public void demandOne(){
        methodA.execute();
        methodB.execute();
        methodC.execute();
    }

    //需求二
    public void demandTwo(){
        methodB.execute();
        methodC.execute();
        methodA.execute();
    }

    //需求三
    public void demandThree(){
        methodC.execute();
        methodA.execute();
        methodB.execute();
    }
}

//方法一
class MethodA{

    public void execute(){
        System.out.println("方法一");
    }
}

//方法二
class MethodB{

    public void execute(){
        System.out.println("方法二");
    }
}

//方法三
class MethodC{

    public void execute(){
        System.out.println("方法三");
    }
}
