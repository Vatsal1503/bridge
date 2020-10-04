package com.bridge.resilience.bridgeresilience.repository;

import com.bridge.resilience.bridgeresilience.model.BRI;

import java.util.List;

public interface BRIDAO {

    public List<BRI> findAll();
    public List<BRI> findByBridge_name(String bridge_name);
}
