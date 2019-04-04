package com.liuxi.zoo.lock;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: liuxi
 * @Date: 2019/4/4 11:26
 * @Description:
 */
public class MyLock extends AbstractLock {

    private CountDownLatch countDownLatch = null;

    @Override
    boolean tryLock() {
        try{
            //zkClient.createEphemeral(PATH);//创建临时节点
            zkClient.createPersistent(PATH);//创建永久节点
            //zkClient.createEphemeralSequential(PATH,1);//创建临时队列节点
            //zkClient.createPersistentSequential(PATH,2);//创建永久队列节点
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    void waitLock() {
        IZkDataListener iZkDataListener = new IZkDataListener() {

            //当节点发生改变
            public void handleDataChange(String s, Object o) throws Exception {

            }

            //当节点删除
            public void handleDataDeleted(String s) throws Exception {
                if(countDownLatch != null){
                    countDownLatch.countDown();
                }
            }
        };

        //注册节点事件
        zkClient.subscribeDataChanges(PATH, iZkDataListener);

        if(zkClient.exists(PATH)){
            countDownLatch = new CountDownLatch(1);

            try {
                countDownLatch.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        zkClient.unsubscribeDataChanges(PATH, iZkDataListener);
    }
}
