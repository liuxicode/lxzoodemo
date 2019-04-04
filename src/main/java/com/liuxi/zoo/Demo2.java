package com.liuxi.zoo;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @Auther: liuxi
 * @Date: 2019/4/4 14:09
 * @Description:
 */
public class Demo2 {

    public static void main(String[] args) {

        ZkClient zkClient = new ZkClient("106.15.120.93:2181");

       /* zkClient.delete("/myData");
        zkClient.createPersistent("/myData","123");*/

       //System.out.println(zkClient.getAcl("/myData").setValue(new Stat()));

        zkClient.createPersistent("/myLockQueue1");

        String data1 = zkClient.createPersistentSequential("/myLockQueue1/","123");

        System.out.println(data1);

        String data2 = zkClient.createPersistentSequential("/myLockQueue1/","123");

        System.out.println(data2);

        String data3 = zkClient.createPersistentSequential("/myLockQueue1/","123");

        System.out.println(data3);

        List<String> list = zkClient.getChildren("/myLockQueue1");

        System.out.println(list);
    }

}
