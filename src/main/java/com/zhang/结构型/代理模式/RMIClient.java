package com.zhang.结构型.代理模式;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;

/**
 * @Author:liZiYuan Date: 2022/6/6  23:46
 */
public class RMIClient {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        //获取特定主机（包括本地主机）在默认注册端口1099上对远程对象Registry的引用
        Registry registry= LocateRegistry.getRegistry();//参数位null对应本机地址
        //从注册表里查找远程名位Clock1的接口Clock类型的对象
        Clock clock=(Clock) registry.lookup("clock1");
        //调用接口方法
        LocalDateTime dt=clock.currentTime();
        System.out.println("RMI result:"+dt);
    }
}
