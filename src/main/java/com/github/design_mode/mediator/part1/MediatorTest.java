package com.github.design_mode.mediator.part1;

/**
 * 中介者模式
 *
 * 不使用中介者模式
 */
public class MediatorTest {

    public static void main(String[] args) {
        PersonA personA = new PersonA();

        PersonB personB = new PersonB();

        personA.setNumber(personB, 3);

        System.out.println(personB.getNumber());

        personB.setNumber(personA, personB.getNumber());

        System.out.println(personA.getNumber());
    }
}

/**
 * 抽象同事类
 */
abstract class AbstractColleague{

    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    abstract void setNumber(AbstractColleague abstractColleague, int number);
}

/**
 * 具体同事类
 */
class PersonA extends AbstractColleague{

    @Override
    void setNumber(AbstractColleague abstractColleague, int number) {
        abstractColleague.setNumber(number * 100);
    }
}

/**
 * 具体同事类
 */
class PersonB extends AbstractColleague{

    @Override
    void setNumber(AbstractColleague abstractColleague, int number) {
        abstractColleague.setNumber(number / 100);
    }
}


