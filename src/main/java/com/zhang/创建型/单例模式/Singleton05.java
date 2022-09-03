package com.zhang.创建型.单例模式;
//Holder方式
//final不允许被继承
public class Singleton05 {

    //实例变量
    private byte[] data=new byte[1024];
    private Singleton05(){

    }
    //在静态内部类中持有Singleton的实例，并且可被直接初始化
    private static class Holder{
        private static Singleton05 instance=new Singleton05();
    }

    public static Singleton05 getInstance(){
        return Holder.instance;
    }
}
