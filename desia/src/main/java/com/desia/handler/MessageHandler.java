package com.desia.handler;

import java.io.ByteArrayOutputStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class MessageHandler implements SOAPHandler<SOAPMessageContext>{

	@Override
	 public boolean handleMessage(SOAPMessageContext smc) {
	     StringBuffer sbuf = new StringBuffer();
	     sbuf.append("\n------------------------------------\n");
	     sbuf.append("In SOAPHandler :handleMessage()\n");

	     Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

	     if (outboundProperty.booleanValue()) {
	        sbuf.append("\ndirection = outbound ");
	     }
	     else {
	        sbuf.append("\ndirection = inbound ");
	     }

	     SOAPMessage message = smc.getMessage();      
	     try {
	        sbuf.append("\n");
	        sbuf.append(message.toString()); 
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        message.writeTo(baos);                     
	        sbuf.append("\nMessage Desc: " + baos.toString());         
	        sbuf.append("\n");
	     }
	     catch (Exception e) {
	        sbuf.append("Exception in SOAP Handler: " + e);
	     }

	     sbuf.append("Exiting SOAPHandler :handleMessage()\n");
	     sbuf.append("------------------------------------\n");
	     System.out.println((sbuf.toString()));
	     return true;
	  }
	
	public boolean handleMessage1(SOAPMessageContext context) {
		
		try {
			SOAPMessage message = context.getMessage();
			SOAPBody soapBody = message.getSOAPBody();
			//soapBody.get
			
			/* Message traveling from/ towards the Bonton service. */
			boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			
			if (outbound) {
				System.out.println("outbound " + soapBody);
			} else {
				System.out.println("inbound " + soapBody.getTextContent());
			}
		} catch (SOAPException e) {
			System.out.println("exception occured");
			//TODO: implement logger
		}
		return false;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return false;
	}

	@Override
	public void close(MessageContext context) {
		
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}
