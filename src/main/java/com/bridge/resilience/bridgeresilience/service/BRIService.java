package com.bridge.resilience.bridgeresilience.service;

import com.bridge.resilience.bridgeresilience.model.BRI;
import com.bridge.resilience.bridgeresilience.repository.BRIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BRIService {

    @Autowired
    private BRIRepository BRIRepository;

    @Transactional
    public List<BRI> findAllServices() {

        return BRIRepository.findAll();
    }

    @Transactional
    public List<BRI> findByIdServices(String bridge_name) {

        return BRIRepository.findByBridge_name(bridge_name);
    }
}
