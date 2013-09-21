package com.avijit.poc.onlinestore.data.dao;

import com.avijit.poc.onlinestore.business.entity.Order;

public interface OrderDAO {
    public boolean saveOrder(Order order);
}
