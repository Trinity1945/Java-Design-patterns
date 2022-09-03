package com.zhang.结构型.代理模式;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

/**
 * @Author:liZiYuan Date: 2022/6/6  23:38
 */
public interface Clock extends Remote {
    //Remote接口：用于标识可以从非本地虚拟机调用其方法，它不包含方法的声明
    //子接口的方法声明中需要使用子句 throws RemoteException
    LocalDateTime currentTime() throws RemoteException;//接口方法
}
