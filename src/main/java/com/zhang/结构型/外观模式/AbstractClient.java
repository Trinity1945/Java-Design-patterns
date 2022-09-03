package com.zhang.结构型.外观模式;

/**
 * @Author:liZiYuan Date: 2022/6/3  23:05
 **/

class Light{//子系统
    private String position;
    public Light(String position){
        this.position=position;
    }
    public void on(){
        System.out.println(this.position+"灯打开！");
    }

    public void off(){
        System.out.println(this.position+"灯关闭");
    }
}

class AirConditioner{//子系统
    public void on(){
        System.out.println("空掉打开");
    }

    public void off(){
        System.out.println("空调关闭");
    }
}

class Television{//子系统
    public void on(){
        System.out.println("电视机打开");
    }

    public  void off(){
        System.out.println("电视机关闭");
    }
}

abstract class abstractFacade{
    abstract void on();
    abstract void off();
}

class LightSwitch extends abstractFacade{

    private Light[] lights=new Light[4];
    public LightSwitch(){
        lights[0]=new Light("左前");
        lights[1]=new Light("右前");
        lights[2]=new Light("左后");
        lights[3]=new Light("右后");
    }

    @Override
    void on() {
        lights[0].on();
        lights[1].on();
        lights[2].on();
        lights[3].on();
    }

    @Override
    void off() {
        lights[0].off();
        lights[1].off();
        lights[2].off();
        lights[3].off();
    }
}

class AirConditionerSwitch extends abstractFacade{
    private AirConditioner ac;
    public AirConditionerSwitch(){
        ac=new AirConditioner();
    }

    @Override
    void on() {
        ac.on();
    }

    @Override
    void off() {
        ac.off();
    }
}

class TelevisionSwitch extends abstractFacade{

    private Television tv;

    public TelevisionSwitch(){
        tv=new Television();
    }

    @Override
    void on() {
        tv.on();
    }

    @Override
    void off() {
        tv.off();
    }
}


public class AbstractClient {
    public static void main(String[] args) {
    abstractFacade af=new LightSwitch();
    af.on();
    af.off();
    }
}
