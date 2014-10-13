package com.avijit.poc.standalone.xml;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.avijit.poc.standalone.xml.bo.PurchaseOrders.PurchaseOrder;

public class StaxXmlParsing {
	public static void main(String[] args) {
		try {
			parseXml();
			
			 /*
		     
		     */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void parseXml() throws Exception {
		
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		InputStream in = new FileInputStream("C:\\Avijit\\GitHub\\java-poc\\Java_Misc\\src\\com\\avijit\\poc\\standalone\\xml\\purchase_orders.xml");
		
		XMLStreamReader streamReader = inputFactory.createXMLStreamReader(in);
		
		JAXBContext context = JAXBContext.newInstance(PurchaseOrder.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		while (streamReader.hasNext()) {
			streamReader.next();
			
			if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) { 

				if (streamReader.getName().getLocalPart() == ("PurchaseOrder")) { 
					
					JAXBElement<PurchaseOrder> purchaseOrderElement = unmarshaller.unmarshal(streamReader, PurchaseOrder.class);
					PurchaseOrder purchaseOrder = purchaseOrderElement.getValue();
					System.out.println(purchaseOrder);
				}
			}
		}
		
	}
	
}
