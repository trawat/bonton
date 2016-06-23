package com.bonton.service.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.bonton.service.ServiceProxy;

/**
 * Acts as a service helper.
 * @author Tirath
 */
public class BontonServiceHelper {
	private static final ExecutorService es = Executors.newCachedThreadPool();
	public void execute(ServiceProxy sp) {
		//final CountDownLatch cdl = new CountDownLatch(3);
		Future<Boolean> result = es.submit(new Runnable() {
			@Override
			public void run() {
				//sp.search(null, null, null);
			}}, true);
		
	}
}
