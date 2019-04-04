package com.liuxi.zoo;

import com.liuxi.zoo.lock.Lock;
import com.liuxi.zoo.lock.MyLock;

/**
 * @Auther: liuxi
 * @Date: 2019/4/4 11:40
 * @Description:
 */
public class MyTask implements Runnable {

    public void run() {

        Lock lock = new MyLock();

        lock.getlock();

        System.out.println(Thread.currentThread().getName()+"执行任务"+System.currentTimeMillis());

        lock.unlock();

    }
}
