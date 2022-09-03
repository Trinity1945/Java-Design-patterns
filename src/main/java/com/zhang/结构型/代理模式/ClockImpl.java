package com.zhang.结构型.代理模式;

import java.rmi.RemoteException;
import java.time.LocalDateTime;

/**
 * @Author:liZiYuan Date: 2022/6/6  23:41
 */
public class ClockImpl implements Clock {//接口实现
    @Override
    public LocalDateTime currentTime() throws RemoteException {
        System.out.println("我被调用了");
        return LocalDateTime.now();//静态方法
    }
}
