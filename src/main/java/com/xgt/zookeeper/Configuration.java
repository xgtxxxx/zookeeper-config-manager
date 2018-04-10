package com.xgt.zookeeper;

import java.io.Serializable;

/**
 * mock data for configuration
 */
public class Configuration implements Serializable {
    private static final long serialVersionUID = -1690536410098271670L;
    private String name;
    private String password;

    public Configuration() {
    }

    public Configuration(final String name, final String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Configuration{" +
            "name='" + name + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
