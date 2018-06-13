package com.github.design_mode.interpreter;

import com.sun.org.apache.xpath.internal.operations.Variable;

import java.util.HashMap;
import java.util.Map;

/**
 * 解释器
 */
public class InterpreterTest {

    public static void main(String[] args) {
        Context ctx = new Context();
        Variable1 x = new Variable1("x");
        Variable1 y = new Variable1("y");

        Constant c = new Constant(true);

        ctx.assign(x, false);
        ctx.assign(y, true);

        Expression exp = new Or(new And(c,x) , new And(y,new Not(x)));
        System.out.println("x=" + x.interpret(ctx));
        System.out.println("y=" + y.interpret(ctx));
        System.out.println(exp.toString() + "=" + exp.interpret(ctx));
    }
}

/**
 * 抽象表达式角色
 */
abstract class Expression{
    /**
     * 以环境为准，本方法解释给定的任何一个表达式
     */
    public abstract boolean interpret(Context ctx);
    /**
     * 检验两个表达式在结构上是否相同
     */
    public abstract boolean equals(Object obj);
    /**
     * 返回表达式的hash code
     */
    public abstract int hashCode();
    /**
     * 将表达式转换成字符串
     */
    public abstract String toString();
}

/**
 * 一个Constant对象代表一个布尔常量
 */
class Constant extends Expression{

    private boolean value;

    public Constant(boolean value){
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj != null && obj instanceof Constant){
            return this.value == ((Constant)obj).value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean interpret(Context ctx) {

        return value;
    }

    @Override
    public String toString() {
        return new Boolean(value).toString();
    }

}

/**
 * 一个Variable对象代表一个有名变量
 */
class Variable1 extends Expression {

    private String name;

    public Variable1(String name){
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {

        if(obj != null && obj instanceof Variable)
        {
            return this.name.equals(
                    ((Variable1)obj).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean interpret(Context ctx) {
        return ctx.lookup(this);
    }

}

/**
 * 代表逻辑“与”操作的And类，表示由两个布尔表达式通过逻辑“与”操作给出一个新的布尔表达式的操作
 */
class And extends Expression {

    private Expression left,right;

    public And(Expression left , Expression right){
        this.left = left;
        this.right = right;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof And)
        {
            return left.equals(((And)obj).left) &&
                    right.equals(((And)obj).right);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean interpret(Context ctx) {

        return left.interpret(ctx) && right.interpret(ctx);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " AND " + right.toString() + ")";
    }

}

/**
 * 代表逻辑“或”操作的Or类，代表由两个布尔表达式通过逻辑“或”操作给出一个新的布尔表达式的操作
 */
class Or extends Expression {
    private Expression left,right;

    public Or(Expression left , Expression right){
        this.left = left;
        this.right = right;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Or)
        {
            return this.left.equals(((Or)obj).left) && this.right.equals(((Or)obj).right);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean interpret(Context ctx) {
        return left.interpret(ctx) || right.interpret(ctx);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " OR " + right.toString() + ")";
    }

}

/**
 * 代表逻辑“非”操作的Not类，代表由一个布尔表达式通过逻辑“非”操作给出一个新的布尔表达式的操作
 */
class Not extends Expression {

    private Expression exp;

    public Not(Expression exp){
        this.exp = exp;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Not)
        {
            return exp.equals(
                    ((Not)obj).exp);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean interpret(Context ctx) {
        return !exp.interpret(ctx);
    }

    @Override
    public String toString() {
        return "(Not " + exp.toString() + ")";
    }

}

/**
 * 环境(Context)类定义出从变量到布尔值的一个映射
 */
class Context {

    private Map<Variable1,Boolean> map = new HashMap();

    public void assign(Variable1 var , boolean value){
        map.put(var, new Boolean(value));
    }

    public boolean lookup(Variable1 var) throws IllegalArgumentException{
        Boolean value = map.get(var);
        if(value == null){
            throw new IllegalArgumentException();
        }
        return value.booleanValue();
    }
}
