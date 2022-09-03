package com.zhang.结构型.代理模式;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Author:liZiYuan Date: 2022/6/6  23:42
 */
public class RMIServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Clock clock=new ClockImpl();//创建接口的实例
        //将接口对象暴露到网络
        Clock stub=(Clock) UnicastRemoteObject.exportObject(clock,1099); //stub桩（存根）
        //创建一个对特定端口调用的远程对象注册表
        Registry registry= LocateRegistry.createRegistry(1099);
        //给远程对象绑定一个使用名称
        registry.bind("clock1",stub);
        System.out.println("Clock Server is ready");
    }
}
