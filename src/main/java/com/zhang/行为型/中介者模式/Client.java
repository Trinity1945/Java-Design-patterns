package com.zhang.行为型.中介者模式;

/**
 * @Author: liZiYuan
 * <p>
 * Date: 2022/8/19  19:31
 */

abstract class Mediator{//抽象中介者
    public abstract void dispatcherMessage(Colleague from,Colleague to,String message);
}

abstract class Colleague{//抽象同事
    protected String name;
    protected Mediator mediator;//聚合

    public Colleague(String name) {
        this.name = name;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void receiveMessage(Colleague from,String message){//普通方法接收消息
        System.out.println(name+"receive from"+from.name+":"+message);
    }

    public abstract void sendMessage(Colleague to,String message);//声明抽象方法
}

class ConcreteMediator extends Mediator{//具体中介者

    @Override
    public void dispatcherMessage(Colleague from, Colleague to, String message) {
        message=message.replaceAll("XX","*");//屏蔽不文明语言
        to.receiveMessage(from,message);
    }
}

class ConcreteColleague extends Colleague{//具体同事

    public ConcreteColleague(String name) {
        super(name);
    }

    @Override
    public void sendMessage(Colleague to, String message) {
        mediator.dispatcherMessage(this,to,message);
    }
}

public class Client {
    public static void main(String[] args) {
        final Mediator mediator = new ConcreteMediator();
        Colleague colleague1,colleague2,colleague3;//创建若干会员并注册
        colleague1=new ConcreteColleague("张三");
        colleague1.setMediator(mediator);
        colleague2=new ConcreteColleague("李四");
        colleague2.setMediator(mediator);
        colleague3=new ConcreteColleague("王五");
        colleague3.setMediator(mediator);
        //会员通过中介者转发消息
        colleague1.sendMessage(colleague2,"李四，你好");
        colleague2.sendMessage(colleague1,"张三，你好");
        colleague1.sendMessage(colleague3,"王五，今天的天气真不错！有鸟");
    }
}
