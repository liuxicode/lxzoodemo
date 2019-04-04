package com.liuxi.zoo.lock;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

/**
 * @Auther: liuxi
 * @Date: 2019/4/4 11:14
 * @Description:
 */
public abstract class AbstractLock implements Lock {

    //zk连接地址
    private static final String CONNECTSTRING = "106.15.120.93:2181";
    //创建zk连接
    protected ZkClient zkClient = new ZkClient(new ZkConnection(CONNECTSTRING));
    //PATH
    protected static final String PATH = "/lock";

    public void getlock() {
        if(tryLock()){
            System.out.println("--------------"+Thread.currentThread().getName()+"获取锁----------------");
        }else {
            waitLock();

            getlock();
        }

    }

    abstract boolean tryLock();

    abstract void waitLock();


    public void unlock() {
        if(zkClient != null ){
            zkClient.delete(PATH);
            zkClient.close();
            System.out.println("--------------"+Thread.currentThread().getName()+"释放锁----------------");
        }
    }
}
