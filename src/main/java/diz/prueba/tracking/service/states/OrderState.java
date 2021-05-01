package diz.prueba.tracking.service.states;

import diz.prueba.tracking.model.OrderTracking;

public interface OrderState {

	public void updateState(OrderTracking orderTracking, OrderState state);
	
	public Long getStateId();
}

