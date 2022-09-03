package com.zhang.行为型.命令模式;

/**
 * @Author: liZiYuan
 * <p>
 * Date: 2022/8/19  17:38
 */

class Receiver{//接收者Receiver
    public void action(){
        System.out.println("Receiver is working!!!");//接收与请求相关的操作
    }
}

abstract class Command{//抽象Command
    protected Receiver receiver;//体现关联；可以移动ConcreteCommand里
    public abstract void execute();//接收者工作方法的抽象
}

class ConcreteCommand extends Command{//具体命令 :ConcreteCommand

    private String state="命令 1 未执行";

    public ConcreteCommand(Receiver receiver) {//构造器注入
        this.receiver = receiver;
        System.out.println(state);
    }

    @Override
    public void execute() {//重写抽象方法
        receiver.action();//调用命令接收者方法
        state="命令 1 已执行";
        System.out.println(state);
    }
}

class ConcreteCommand2 extends Command{//具体命令 :ConcreteCommand

    private String state="命令 2 未执行";

    public ConcreteCommand2(Receiver receiver) {//构造器注入
        this.receiver = receiver;
        System.out.println(state);
    }

    @Override
    public void execute() {//重写抽象方法
        receiver.action();//调用命令接收者方法
        state="命令 2 已执行";
        System.out.println(state);
    }
}

class Invoker{//调用者 Invoker
    private Command command;//聚合

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call(){//定义请求方法
        command.execute();
    }
}

public class Client {//客户端
    public static void main(String[] args) {
    //下面的代码是通过命令请求者执行命令的
        System.out.println("===========命令模式=============");
        final Receiver receiver = new Receiver();//创建命令接收者；Client 关联 Receiver
        //Client 依赖 ConcreteCommand; 作为参数类型
        final Invoker invoker = new Invoker();//将命令请求者
        invoker.setCommand(new ConcreteCommand(receiver));
        invoker.call();//由请求者发送命令
        //下面的代码也能实现上面代码的功能，并未使用Invoker类（非命令模式-----直接使用）
        System.out.println("===========不适用命令模式=============");
        receiver.action();
        //使用新的具体命令
        invoker.setCommand(new ConcreteCommand2(receiver));
        invoker.call();
    }
}
