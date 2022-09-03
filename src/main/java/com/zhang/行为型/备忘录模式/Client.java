package com.zhang.行为型.备忘录模式;

/**
 * @Author: liZiYuan
 * <p>
 * Date: 2022/8/18  21:16
 */

class Originator{
    //原发器，用于创建和恢复备忘录
    private String state;
    public String getState(){
        return state;
    }

    public Memento createMemento(){
        return new Memento(state);//保存当前状态至备忘录
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setMemento(Memento memento){
        state=memento.getState();//
    }
}

class Memento{
 private String state;
 public Memento(String state){
     this.state=state;
 }

 public void setState(String state){
     this.state=state;
 }

 public String getState(){
     return state;
 }
}

class Caretaker{//看管者，管理备忘录对象（可保存和获取，但不能修改）
    private Memento memento;//聚合关联
    public Memento getMemento(){
        return memento;
    }

    public void setMemento(Memento memento){
        this.memento=memento;
    }

}

public class Client {
    public static void main(String[] args) {
        final Originator originator = new Originator();//创建一个游戏角色
        final Caretaker caretaker = new Caretaker();//闯将游戏角色状态看管者
        originator.setState("状态1  攻击力   100");
        caretaker.setMemento(originator.createMemento());//保存当前状态
        caretaker.setMemento(caretaker.getMemento());//原发器通过看管者恢复状态
        System.out.println("当前状态："+originator.getState());
        originator.setState("状态2  攻击力   80");
        caretaker.setMemento(originator.createMemento());//保存当前状态
        caretaker.setMemento(caretaker.getMemento());//原发器通过看管者恢复状态
        System.out.println("当前状态："+originator.getState());
    }
}
