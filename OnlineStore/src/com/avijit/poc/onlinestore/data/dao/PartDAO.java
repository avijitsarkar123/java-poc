package com.avijit.poc.onlinestore.data.dao;

import java.util.List;

import com.avijit.poc.onlinestore.business.entity.Part;
import com.avijit.poc.onlinestore.business.entity.PartSpecification;

public interface PartDAO {
    public List<Part> getPartsByManufacturer(long manufacturerId);
    public List<Part> getPartsByPartType(long manufacturerId);
    public Part getPartDetailsByPartCd(long partId);
    public List<PartSpecification> getPartSpecification(long partId);
}
