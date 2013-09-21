package com.avijit.poc.onlinestore.data.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.avijit.poc.onlinestore.business.entity.Manufacturer;
import com.avijit.poc.onlinestore.data.dao.ManufacturerDAO;

@Repository
public class ManufacturerJpaDAO implements ManufacturerDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Manufacturer> getManufacturerList() {
        Query query = entityManager.createQuery("SELECT m FROM Manufacturer m");
		return (List<Manufacturer>) query.getResultList();
    }
}
