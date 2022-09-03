package com.zhang.行为型.观察者模式;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liZiYuan
 * <p>
 * Date: 2022/8/18  21:59
 */

abstract class Observer{//抽象观察者
    public abstract void update(Subject subject);//更新观察到的消息
}

abstract class Subject{//目标
    //维系若干个观察者，体现Subject对Observer的关联
    public List<Observer> observers=new ArrayList<>();

    public List<Observer> getObservers() {
        return observers;
    }

    public void notifyToAll(){//通知
        for (Observer observer : observers) {
            observer.update(this);//体现Subject和Observer之间的关联
        }
    }

    public abstract void attach(Observer observer);//附加观察者
    public abstract void detach(Observer observer);//移除观察者
}

class ConcreteObserver extends Observer{

    private String name;//观察者名称
    private String observerState;//观察到的状态

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject subject) {
        observerState=((ConcreteSubject)subject).getSubjectState();//体现对ConcreteSubject的关联
        System.out.println(name+"收到消息"+observerState);
    }
}

class ConcreteSubject extends Subject{//具体目标

    private String subjectState;//目标状态

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }

    public String getSubjectState() {
        return subjectState;
    }

    @Override
    public void attach(Observer observer) {
        getObservers().add(observer);
    }

    @Override
    public void detach(Observer observer) {
    getObservers().remove(observer);
    }
}
public class Client {
    public static void main(String[] args) {
        //创建一个观察目标
        final ConcreteSubject concreteSubject = new ConcreteSubject();
        //创建观察者
        final ConcreteObserver observer1 = new ConcreteObserver("张三");
        final ConcreteObserver observer2 = new ConcreteObserver("李四");
        final ConcreteObserver observer3 = new ConcreteObserver("王五");
        //添加观察者到目标
        concreteSubject.attach(observer1);
        concreteSubject.attach(observer2);
        concreteSubject.attach(observer3);
        //观察目标设置状态
        ((ConcreteSubject)concreteSubject).setSubjectState("明天下午考设计模式");
        //观察目标发布通知
        concreteSubject.notifyToAll();
        System.out.println("==========================================");
        concreteSubject.detach(observer3);
        ((ConcreteSubject)concreteSubject).setSubjectState("后天上午考java EE");
        concreteSubject.notifyToAll();
    }

}
