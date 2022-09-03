package com.zhang.行为型.状态模式;

/**
 * @Author: liZiYuan
 * <p>
 * Date: 2022/8/19  18:51
 */

abstract class State{//抽象状态
    public abstract String handle();
}

class ConcreteStateA extends State{//具体状态

    @Override
    public String handle() {
        return "10%";
    }
}

class ConcreteStateB extends State{//具体状态

    @Override
    public String handle() {
        return "20%";
    }
}

class Context{
    private State state;//Context聚合State
    public void setState(State state){
        this.state=state;
    }

    public String request(){
        return state.handle();//供客户端请求的方法
    }
}

public class Client {
    public static void main(String[] args) {
        //Client 关联 State,客户端程序面向抽象编程
        final Context context = new Context();
        //对象在其内部状态改变时，可改变其行为
        context.setState(new ConcreteStateA());//设置状态
        System.out.println("按照普通客户的折扣："+context.request());
        context.setState(new ConcreteStateB());//改变状态
        System.out.println("按照VIP客户的折扣："+context.request());
    }
}
