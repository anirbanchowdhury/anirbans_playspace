package com.anicompany.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Anirban on 4/27/2014.
 */
public class Owner {
    private int ownerId;
    private Map<String,Pool> poolMap;



    public Owner(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public Map<String,Pool> getpoolMap() {
        return poolMap;
    }

    public void setpoolMap(Map<String,Pool> poolMap) {
        this.poolMap = poolMap;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", poolMap=" + poolMap +
                '}';
    }
}
