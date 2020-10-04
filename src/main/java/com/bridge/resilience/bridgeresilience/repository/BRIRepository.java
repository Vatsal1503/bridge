package com.bridge.resilience.bridgeresilience.repository;

import com.bridge.resilience.bridgeresilience.model.BRI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BRIRepository implements BRIDAO{
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

        Query thequery = entitymanager.createQuery("from Employee where bridge_name=:bridge_name");
        thequery.setParameter("bridge_name", bridge_name);
        List<BRI> thebri=thequery.getResultList();

        return thebri;
    }
}
