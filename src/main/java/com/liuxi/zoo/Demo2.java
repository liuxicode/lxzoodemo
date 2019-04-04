package com.liuxi.zoo;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.data.Stat;

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

        System.out.println(zkClient.getAcl("/myData").setValue(new Stat()));

    }

}
