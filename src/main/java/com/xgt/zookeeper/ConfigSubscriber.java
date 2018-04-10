package com.xgt.zookeeper;

import org.I0Itec.zkclient.IZkDataListener;

public class ConfigSubscriber extends Client implements Runnable {
    private final String clientName;

    public ConfigSubscriber(final String clientName) {
        this.clientName = clientName;
    }

    public void subScribe() {
        getClient().subscribeDataChanges(AppConstants.CONFIG_PATH, new IZkDataListener() {
            @Override
            public void handleDataChange(final String node, final Object o) throws Exception {
                System.out.println(String.format("%s: Configuration on node: %s is changed! The new value is: %s", clientName, node, o.toString()));
                handleConfiguration((Configuration)o);
            }

            @Override
            public void handleDataDeleted(final String node) throws Exception {
                System.out.println(String.format("%s: Configuration on node: %s is removed!", clientName, node));
                handleConfiguration(null);
            }
        });
    }

    private void handleConfiguration(final Configuration configuration) {
        System.out.println(clientName + " is processing=====>" + configuration);
    }

    @Override
    public void run() {
        subScribe();
    }
}
