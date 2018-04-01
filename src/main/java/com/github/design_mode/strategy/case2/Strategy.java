package com.github.design_mode.strategy.case2;

public class Strategy {

}

//中国公民
abstract class Chinese {

    protected PayTaxes payTaxes;
    protected Double income;

    public double PayTaxes(){
        return payTaxes.payTaxes(getIncome());
    }

    public void setPayTaxes(PayTaxes payTaxes) {
        this.payTaxes = payTaxes;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }


}

//缴税接口
interface PayTaxes{
    Double payTaxes(double income);
}

//一档 5000 - 10000
class PayTaxes1 implements PayTaxes{

    @Override
    public Double payTaxes(double income) {
        return income * .10;
    }
}

//二档 10000 - 15000
class PayTaxes2 implements PayTaxes{

    @Override
    public Double payTaxes(double income) {
        return income * .15;
    }
}

//三档 15000 - 20000
class PayTaxes3 implements PayTaxes{

    @Override
    public Double payTaxes(double income) {
        return income * .20;
    }
}


//公民张三
class Zhangsan extends Chinese{

    public Zhangsan(double income){
        super.income = income;
        super.payTaxes = new PayTaxes1();
    }
}

//公民李四
class Lisi extends Chinese {

    public Lisi(double income){
        super.income = income;
        super.payTaxes = new PayTaxes2();
    }
}

