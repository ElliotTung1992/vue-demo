package com.github.design_mode.mediator.part2;

/**
 * 中介者模式
 *
 * 使用中介者模式
 */
public class MediatorTest {

    public static void main(String[] args) {
        PersonA personA = new PersonA();
        PersonB personB = new PersonB();
        Mediator mediator = new Mediator(personA, personB);
        personA.setNumber(mediator, 9);

        System.out.println(personB.getNumber());

        personB.setNumber(mediator, 100);

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

    abstract void setNumber(AbstractMediator mediator, int number);
}

/**
 * 具体同事类
 */
class PersonA extends AbstractColleague{

    @Override
    void setNumber(AbstractMediator mediator, int number) {
        mediator.affectB(number);
    }
}

/**
 * 具体同事类
 */
class PersonB extends AbstractColleague{

    @Override
    void setNumber(AbstractMediator mediator, int number) {
        mediator.affectA(number);
    }
}

/**
 * 抽象中介者
 */
abstract class AbstractMediator{

    AbstractColleague A;
    AbstractColleague B;

    public AbstractMediator(AbstractColleague A, AbstractColleague B){
        this.A = A;
        this.B = B;
    }

    abstract void affectA(int num);
    abstract void affectB(int num);
}

/**
 * 中介者
 */
class Mediator extends AbstractMediator {

    public Mediator(AbstractColleague A, AbstractColleague B) {
        super(A, B);
    }

    @Override
    void affectA(int num) {
        A.setNumber(num / 100);
    }

    @Override
    void affectB(int num) {
        B.setNumber(num * 100);
    }
}