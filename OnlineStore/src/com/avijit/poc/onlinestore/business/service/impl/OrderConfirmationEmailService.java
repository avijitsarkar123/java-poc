package com.avijit.poc.onlinestore.business.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.avijit.poc.onlinestore.business.entity.Order;
import com.avijit.poc.onlinestore.business.service.jms.OrderConfirmationEmailMessageListener;

public class OrderConfirmationEmailService {
    private VelocityEngine velocityEngine;
    private String velocityTemplate;
    private JavaMailSender mailSender;
    private SimpleMailMessage templateMessage;
    private OrderConfirmationEmailMessageListener orderConfirmationMailJmsReceiverder;

    public void sendMail() throws Exception {
    	System.out.println("OrderConfirmationEmailService Invoked");
    	final Order order = null; //orderConfirmationMailJmsReceiverder.receiveMessage();
    	
    	if (order != null) {
	        MimeMessagePreparator preparator = new MimeMessagePreparator() {
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
	                message.setTo("");
	                message.setFrom(templateMessage.getFrom());
	                message.setSubject(templateMessage.getSubject());
	                addImagesToEmail(message);
	                Map model = new HashMap();
	                model.put("order", order);
	                String text = VelocityEngineUtils.mergeTemplateIntoString(
	                        velocityEngine, velocityTemplate, model);
	                message.setText(text, true);
	            }
	        };
	        this.mailSender.send(preparator);
    	}
    }

    public JavaMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public SimpleMailMessage getTemplateMessage() {
        return templateMessage;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    public VelocityEngine getVelocityEngine() {
        return velocityEngine;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public String getVelocityTemplate() {
        return velocityTemplate;
    }

    public void setVelocityTemplate(String velocityTemplate) {
        this.velocityTemplate = velocityTemplate;
    }

	public void setOrderConfirmationMailJmsReceiverder(
			OrderConfirmationEmailMessageListener orderConfirmationMailJmsReceiverder) {
		this.orderConfirmationMailJmsReceiverder = orderConfirmationMailJmsReceiverder;
	}
	
	public void addImagesToEmail(MimeMessageHelper message) {
		try {
			message.addInline("tasqheaderlogo", new ClassPathResource("images/mylogo.gif"));
			message.addInline("printerlogo", new ClassPathResource("images/printer.gif"));
			message.addInline("checkoutlogo", new ClassPathResource("images/checkout1.gif"));
			message.addInline("tasqfooterlogo", new ClassPathResource("images/logo-footer.gif"));
			message.addInline("css", new ClassPathResource("css/main.css"));
		} catch (javax.mail.MessagingException e) {
			e.printStackTrace();
		} 
		
	}

}