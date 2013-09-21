package com.avijit.poc.onlinestore.data.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.avijit.poc.onlinestore.business.entity.PartType;
import com.avijit.poc.onlinestore.data.dao.PartTypeDAO;

@Repository
public class PartTypeJpaDAO implements PartTypeDAO {
    
	@PersistenceContext
	EntityManager entityManager;
	
	public List<PartType> getPartTypeList() {
		
		Query query = entityManager.createQuery("SELECT pt FROM PartType pt");
		return (List<PartType>) query.getResultList();
    }
}
