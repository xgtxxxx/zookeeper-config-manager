package com.xgt.zookeeper;

import org.I0Itec.zkclient.ZkClient;

import static com.xgt.zookeeper.AppConstants.*;

public abstract class Client {
    ZkClient getClient() {
        return new ZkClient(SERVER_URL1 + ',' + SERVER_URL2 + ',' + SERVER_URL3);
    }
}
