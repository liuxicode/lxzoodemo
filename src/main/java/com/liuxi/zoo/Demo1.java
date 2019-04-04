package com.liuxi.zoo;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @Auther: liuxi
 * @Date: 2019/4/4 11:06
 * @Description:
 */
public class Demo1 {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        for (int i=0;i<10;i++) {
            new Thread(new MyTask()).start();
        }
    }

}
