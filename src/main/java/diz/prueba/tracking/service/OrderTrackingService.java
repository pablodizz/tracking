package diz.prueba.tracking.service;

import java.util.List;

import diz.prueba.tracking.controller.OrderTrackingWrapper;
import diz.prueba.tracking.model.OrderTracking;

public interface OrderTrackingService {

	public OrderTracking save(OrderTracking orderTracking);
	
	public List<OrderTracking> saveAll(List<OrderTracking> orders);
	
	public OrderTrackingWrapper wrap(List<OrderTracking> orders);
	
}
