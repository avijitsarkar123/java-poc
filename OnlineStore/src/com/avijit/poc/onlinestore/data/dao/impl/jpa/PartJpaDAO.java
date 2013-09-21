package com.avijit.poc.onlinestore.data.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.avijit.poc.onlinestore.business.entity.Part;
import com.avijit.poc.onlinestore.business.entity.PartSpecification;
import com.avijit.poc.onlinestore.data.dao.PartDAO;

@Repository
public class PartJpaDAO implements PartDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<Part> getPartsByManufacturer(long manufacturerId) {
       
		Query query = entityManager.createQuery("Select p FROM Part p where p.manufacturer.id = ?1");
		query.setParameter(1, manufacturerId);
		return (List<Part>) query.getResultList();
    }

    public List<Part> getPartsByPartType(long partTypeId) {
    	
    	Query query = entityManager.createQuery("Select p FROM Part p where p.partType.id = ?1");
    	query.setParameter(1, partTypeId);
		return (List<Part>) query.getResultList();
    }

    public Part getPartDetailsByPartCd(long partId) {
    	return (Part) entityManager.find(Part.class, new Long(partId));
    }

    public List<PartSpecification> getPartSpecification(long partId) {
    	
    	Query query = entityManager.createQuery("Select ps FROM PartSpecification ps where ps.part.id = ?1");
    	query.setParameter(1, partId);
		return (List<PartSpecification>) query.getResultList();
    }

}
