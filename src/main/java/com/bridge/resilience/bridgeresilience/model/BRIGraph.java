package com.bridge.resilience.bridgeresilience.model;

import java.sql.Timestamp;

public class BRIGraph {
    private double bridge_resilience;
    private Timestamp createDate;

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
//    public long getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(long createDate) {
//        this.createDate = createDate;
//    }


    public double getBridge_resilience() {
        return bridge_resilience;
    }

    public void setBridge_resilience(double bridge_resilience) {
        this.bridge_resilience = bridge_resilience;
    }


}
