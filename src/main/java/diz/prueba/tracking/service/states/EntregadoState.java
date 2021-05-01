package diz.prueba.tracking.service.states;

import diz.prueba.tracking.model.OrderTracking;

public class EntregadoState implements OrderState{

	private static Long stateId = 4L;
	
	@Override
	public void updateState(OrderTracking orderTracking, OrderState state) {
	}

	@Override
	public Long getStateId() {
		return EntregadoState.stateId;
	}
	
	

}
