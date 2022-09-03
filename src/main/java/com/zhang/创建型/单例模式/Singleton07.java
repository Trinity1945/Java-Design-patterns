package com.zhang.创建型.单例模式;
//Holder模式
public class Singleton07 {

    //实例变量
    private byte[] data=new byte[1024];

    private Singleton07(){

    }

    private enum EnumHolder{
        INSTANCE;
        private Singleton07 instance;
        EnumHolder(){
            this.instance=new Singleton07();
        }

        private Singleton07 getInstance(){
            return instance;
        }
    }

    public static Singleton07 getInstance(){
        return EnumHolder.INSTANCE.getInstance();
    }
}
