package com.bridge.resilience.bridgeresilience.service;

import com.bridge.resilience.bridgeresilience.model.BRI;
import com.bridge.resilience.bridgeresilience.repository.BRICalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("briCalculationService")
public class BRICalculationService {

    @Autowired
    private BRICalculationRepository BRICalculationRepository;

    @Transactional
    public double save(BRI bri,String name){
        double thebri=BRICalculationRepository.getsaveAndGenrateBRIValue(bri,name);
        return thebri;
    }
}
