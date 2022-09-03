package com.zhang.创建型.单例模式;

import java.net.Socket;
import java.sql.Connection;

//Double+Check
//final不允许被继承
public class Singleton04 {

    //实例变量
    private byte[] data=new byte[1024];

    private static Singleton04 instance=null;

    Connection conn;

    Socket socket;

    private Singleton04(){
//    this.conn;//初始化conn
//    this.socket;//初始化socket
    }
    public static Singleton04 getInstance(){
        if(null==instance){
            //只有一个线程能够获得Singleton.class关联的monitor
            synchronized (Singleton04.class){
                //判断如果instance未null则创建
                if(null==instance){
                    instance=new Singleton04();
                }
            }
        }
        return instance;
    }


}
