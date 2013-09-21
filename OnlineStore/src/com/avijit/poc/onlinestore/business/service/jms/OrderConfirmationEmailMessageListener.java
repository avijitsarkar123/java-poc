package com.avijit.poc.onlinestore.business.service.jms;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.avijit.poc.onlinestore.business.entity.Order;

@Service("orderConfirmationEmailMessageListener")
public class OrderConfirmationEmailMessageListener implements MessageListener{

	@Autowired
	JavaMailSender mailSender;
	@Autowired
	SimpleMailMessage orderConfirmationEmailTemplateMessage;
	@Autowired
	private VelocityEngine velocityEngine;
	
	@Override
	public void onMessage(Message message) {
		
		if (message instanceof ObjectMessage) {
			
			try {
				final Order order = (Order) ((ObjectMessage) message).getObject();
				System.out.println("Order Number: " + order.getOrderNumber());
				
				 MimeMessagePreparator preparator = new MimeMessagePreparator() {
			            public void prepare(MimeMessage mimeMessage) throws Exception {
			                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
			                message.setTo(orderConfirmationEmailTemplateMessage.getTo());
			                message.setFrom(orderConfirmationEmailTemplateMessage.getFrom());
			                message.setSubject(orderConfirmationEmailTemplateMessage.getSubject());
			                addImagesToEmail(message);
			                Map<String, Object> model = new HashMap<String, Object>();
			                model.put("order", order);
			                
			                String text = VelocityEngineUtils.mergeTemplateIntoString(
			                        			velocityEngine, 
			                        			"VelocityOrderConfirmationMailTemplate.vm", 
			                        			model);
			                message.setText(text, true);
			            }
			        };
			        
			        this.mailSender.send(preparator);
				
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addImagesToEmail(MimeMessageHelper message) {
		try {
			message.addInline("headerlogo", new ClassPathResource("online-store-logo.jpg"));
			message.addInline("printerlogo", new ClassPathResource("printer.gif"));
			message.addInline("footerlogo", new ClassPathResource("online-store-logo.jpg"));
			message.addInline("css", new ClassPathResource("main.css"));
		} catch (javax.mail.MessagingException e) {
			e.printStackTrace();
		} 
	}

}
