package com.bonton.service.impl;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.bonton.service.ServiceActuator;
import com.bonton.service.ServiceProxy;
import com.bonton.service.adapter.DesiaServiceProxyAdapter;
import com.bonton.service.adapter.ExpediaServiceProxyAdapter;
import com.bonton.service.adapter.HBServiceProxyAdapter;
import com.bonton.utility.artifacts.BTNConfirmRequest;
import com.bonton.utility.artifacts.BTNRepriceRequest;
import com.bonton.utility.processor.XmlProcessor;

public class ServiceActuatorImpl implements ServiceActuator {
	private static final ExecutorService es = Executors.newCachedThreadPool();
	
	@Override
	public String search(List<? extends ServiceProxy> serviceList, InputStream is) throws Exception {
		String uuid = UUID.randomUUID().toString();
		boolean manySp = serviceList.size() > 1;
		
		List<Future<Boolean>> taskLst = new LinkedList<Future<Boolean>>();
		
		/* Trigger task threads */
		for (ServiceProxy sp : serviceList) {
			Future<Boolean> submtedTask = es.submit(new Runnable() {
				@Override
				public void run() {
					try {
						sp.search(is, uuid, manySp);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}}, true);
			taskLst.add(submtedTask);
		}
		
		/* Wait for all the submitted tasks to complete */
		for (Future<Boolean> task : taskLst) {
			task.get();
		}
		
		/* Start result aggregation process. Done by the initial thread. */
		
		/* For one SP, return the result as it is.*/
		if (!manySp) {
			if (serviceList.get(0) instanceof HBServiceProxyAdapter) {
				return XmlProcessor.getBeanInXml(serviceList.get(0).getHBServiceInstance().getAvailabilityRS(uuid));
			} else if (serviceList.get(0) instanceof DesiaServiceProxyAdapter) {
				//return XmlProcessor.getBeanInXml(serviceList.get(0).getDesiaServiceInstance().getAvailabilityRS(uuid));
			} else if (serviceList.get(0) instanceof ExpediaServiceProxyAdapter) {
				//return XmlProcessor.getBeanInXml(serviceList.get(0).getHBServiceInstance().getAvailabilityRS(uuid));
			} else {
				//TODO: put in a check for the case none of the services are available
			}
			
//			Class<?> serviceType = (Class<?>) serviceList.get(0).getServiceInstance().getClass().get;
//			 ((serviceType) serviceList.get(0).getServiceInstance())
		}
		BTNSearchResponse bTNSearchResponse = new BTNSearchResponse();
		Map<String, >
		for () {}
		
		return null;
	}
	
	@Override
	public String confirm(InputStream is) throws Exception {
		BTNConfirmRequest confirmBean = XmlProcessor.getBTNConfirmRQBean(is);
		String supplier = confirmBean.getSupplier();
		
		if ("HotelBeds".equalsIgnoreCase(supplier)) {
			return new HBServiceProxyAdapter().confirmBooking(supplier, confirmBean);
		}
		
		return null;
	}

	@Override
	public String cancel(InputStream is) throws Exception {
		return null;
	}

	@Override
	public String repricing(InputStream is) throws Exception {
		BTNRepriceRequest repriceBean = XmlProcessor.getBTNRepriceRQBean(is);
		String supplier = repriceBean.getSupplier();
		
		if ("HotelBeds".equalsIgnoreCase(supplier)) {
			return new HBServiceProxyAdapter().repricing(supplier, repriceBean);
		}
		return null;
	}
	
}
