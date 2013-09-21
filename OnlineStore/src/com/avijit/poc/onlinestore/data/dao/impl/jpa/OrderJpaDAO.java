package com.avijit.poc.onlinestore.data.dao.impl.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.avijit.poc.onlinestore.business.entity.Order;
import com.avijit.poc.onlinestore.data.dao.OrderDAO;

@Repository
public class OrderJpaDAO  implements OrderDAO {

	@PersistenceContext
	EntityManager entityManager;
	
    public boolean saveOrder(Order order) {
    	try {
    		entityManager.persist(order);
    	} catch (Throwable t) {
    		t.printStackTrace();
    	}
        return true;
    }
}
