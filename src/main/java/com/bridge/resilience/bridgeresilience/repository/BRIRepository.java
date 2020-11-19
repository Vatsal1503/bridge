package com.bridge.resilience.bridgeresilience.repository;

import com.bridge.resilience.bridgeresilience.controller.WebController;
import com.bridge.resilience.bridgeresilience.model.BRI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BRIRepository implements BRIDAO{
    private static Logger logger = LoggerFactory.getLogger(BRIRepository.class);
    @Autowired
    private EntityManager entitymanager;

    @Override
    public List<BRI> findAll() {

        TypedQuery<BRI> thequery = entitymanager.createQuery("from BRI",BRI.class);

        List<BRI> thebri=thequery.getResultList();

        return thebri;
    }

    @Override
    public List<BRI> findByBridge_name(String bridge_name) {

        Query thequery= entitymanager.createQuery("from BRI where BRI.bridge_name IN (:bridge_name)");
        thequery.setParameter("bridge_name", bridge_name);
        List<BRI> thebri=thequery.getResultList();
        for (BRI  b1:thebri) {
            logger.info("Bridge Name :"+b1.getBridge_name());
        }
        return thebri;
    }
}
