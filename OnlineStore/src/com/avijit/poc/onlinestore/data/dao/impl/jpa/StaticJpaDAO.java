package com.avijit.poc.onlinestore.data.dao.impl.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.avijit.poc.onlinestore.business.entity.Bank;
import com.avijit.poc.onlinestore.business.entity.Country;
import com.avijit.poc.onlinestore.business.entity.CreditCardType;
import com.avijit.poc.onlinestore.business.entity.ShippingMethod;
import com.avijit.poc.onlinestore.business.entity.State;
import com.avijit.poc.onlinestore.data.dao.StaticDAO;

@Repository
public class StaticJpaDAO implements StaticDAO {
    
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<CreditCardType> getCreditCardTypeList() {
		Query query = entityManager.createQuery("Select cct from CreditCardType cct");
		return (List<CreditCardType>) query.getResultList();
    }

    public List<ShippingMethod> getShippingMethodTypeList() {
    	Query query = entityManager.createQuery("Select sm from ShippingMethod sm");
		return (List<ShippingMethod>) query.getResultList();
    }
    
    public List<Bank> getBankList() {
    	Query query = entityManager.createQuery("Select b from Bank b");
		return (List<Bank>) query.getResultList();
    }

    public List<Country> getCountryList() {
        Country country;
        List<Country> countryList = new ArrayList<Country>();

        country = new Country();
        country.setId(1);
        country.setCountryCd("US");
        country.setCountryName("United States");
        countryList.add(country);

        country = new Country();
        country.setId(2);
        country.setCountryCd("CA");
        country.setCountryName("Canada");
        countryList.add(country);

        return countryList;
    }

    public List<State> getStateListByCountryCd(String countryCd) {
        State state;
        List<State> stateList = new ArrayList<State>();
        if (countryCd.equals("US")) {
            state = new State();
            state.setId(1);
            state.setStateCd("FL");
            state.setStateName("Florida");
            stateList.add(state);

            state = new State();
            state.setId(2);
            state.setStateCd("CA");
            state.setStateName("California");
            stateList.add(state);

            state = new State();
            state.setId(3);
            state.setStateCd("GA");
            state.setStateName("Georgia");
            stateList.add(state);
        } else if (countryCd.equals("CA")) {
            state = new State();
            state.setId(4);
            state.setStateCd("MA");
            state.setStateName("Manitoba");
            stateList.add(state);

            state = new State();
            state.setId(5);
            state.setStateCd("QB");
            state.setStateName("Quebec");
            stateList.add(state);
        }

        return stateList;
    }
}
