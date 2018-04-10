package com.xgt.zookeeper;

import org.I0Itec.zkclient.ZkClient;

public class ConfigManager extends Client {
    public void publishConfiguration(final Configuration configuration) {
        final ZkClient client = getClient();
        if(!client.exists(AppConstants.CONFIG_PATH)){
            client.createPersistent(AppConstants.CONFIG_PATH, true);
        }

        client.writeData(AppConstants.CONFIG_PATH, configuration);
        System.out.println("==================configuration updated==================");
    }
}
