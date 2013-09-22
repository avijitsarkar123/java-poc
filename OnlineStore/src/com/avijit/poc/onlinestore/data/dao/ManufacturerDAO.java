package com.avijit.poc.onlinestore.data.dao;

import java.util.List;

import com.avijit.poc.onlinestore.business.entity.Manufacturer;

/**
 * Manufacturer DAO
 * 
 * @author avijit
 *
 */
public interface ManufacturerDAO {
    public List<Manufacturer> getManufacturerList();
}
