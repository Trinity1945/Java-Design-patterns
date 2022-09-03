package com.zhang.行为型.策略模式;

/**
 * @Author: liZiYuan
 * <p>
 * Date: 2022/8/18  21:05
 */

interface Strategy{//抽象策略接口
    public void algorithmInterface();//定义算法接口
}

class ConcreteStrategyA implements  Strategy{//具体策略

    @Override
    public void algorithmInterface() {
        System.out.println("Speak English");
    }
}

class ConcreteStrategyB implements  Strategy{//具体策略

    @Override
    public void algorithmInterface() {
        System.out.println("Speak Chinese");
    }
}

class Context{//上下文环境类
    Strategy strategy;//聚合Strategy
    public void setStrategy(Strategy strategy){
        this.strategy=strategy;
    }

    public void contextInterface(){//定义上下文接口的方法
        strategy.algorithmInterface();//调用策略算法接口
    }
}

public class Client {
    public static void main(String[] args) {
        //创建一个具体策略，也可以使用XML文件定义的类
        Strategy strategy=new ConcreteStrategyA();
        Strategy strategy1=new ConcreteStrategyB();
        //创建上下文对象，并选用对应的策略
        final Context context = new Context();
//        context.setStrategy(strategy);
        context.setStrategy(strategy1);
        context.contextInterface();
    }
}
