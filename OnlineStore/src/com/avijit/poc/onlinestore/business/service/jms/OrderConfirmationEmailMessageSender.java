package com.avijit.poc.onlinestore.business.service.jms;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.avijit.poc.onlinestore.business.entity.Order;

@Service("orderConfirmationEmailMessageSender")
public class OrderConfirmationEmailMessageSender {
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Queue orderConfirmationEmailQueue;
	
	public void sendOrderConfirmationEmail(final Order order) {
		jmsTemplate.convertAndSend(orderConfirmationEmailQueue, order);
	}
}
