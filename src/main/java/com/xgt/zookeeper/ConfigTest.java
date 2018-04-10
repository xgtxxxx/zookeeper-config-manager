package com.xgt.zookeeper;

import java.util.Arrays;
import java.util.List;

public class ConfigTest {
    public static void main(final String[] args) throws Exception {
        final ConfigManager configManager = new ConfigManager();
        Thread.sleep(1000);
        final List<ConfigSubscriber> subscribers = Arrays.asList(
            new ConfigSubscriber("Subscriber1"),
            new ConfigSubscriber("Subscriber2"),
            new ConfigSubscriber("Subscriber3"));
        startSubscribe(subscribers);
        configManager.publishConfiguration(new Configuration("Gavin", "123456"));
        Thread.sleep(5000);
        configManager.publishConfiguration(new Configuration("Gavin", "654321"));

        Thread.sleep(Integer.MAX_VALUE);
    }

    private static void startSubscribe(final List<ConfigSubscriber> configSubscribers) {
        configSubscribers
            .stream()
            .forEach(subscriber -> {
                new Thread(subscriber).start();
            });
    }
}
