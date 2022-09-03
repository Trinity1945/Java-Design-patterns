package com.zhang.行为型.模板方法模式;

/**
 * @Author: liZiYuan
 * <p>
 * Date: 2022/8/18  21:11
 */

abstract class AbstractClass{//抽象类，想象成银行
    //原语方法
    protected abstract void primitiveOperation1();//想象成取号
    protected abstract void primitiveOperation2();//想象成交易
    protected abstract void primitiveOperation3();//想象成评价

    public final void templateMethod(){//定义模板方法，final修饰使得子类不可重写
        primitiveOperation1();
        primitiveOperation2();
        primitiveOperation3();
    }

}

class ConcreteClass extends AbstractClass{

    @Override
    protected void primitiveOperation1() {
        System.out.println("从中国银行取号");
    }

    @Override
    protected void primitiveOperation2() {
        System.out.println("从中国银行交易");
    }

    @Override
    protected void primitiveOperation3() {
        System.out.println("从中国银行评价");
    }
}

public class Client {
    public static void main(String[] args) {
        AbstractClass bank=new ConcreteClass();
        bank.templateMethod();
    }
}
